package com.capcom.monitoring.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.capcom.monitoring.mapper.MonitorMapper;
import com.capcom.monitoring.model.Monitor;
import com.capcom.monitoring.model.MonitorRequest;
import com.capcom.monitoring.model.MovieSearchResult;
import com.capcom.monitoring.utils.MonitorUtils;

@Component
public class SearchDAOImpl implements SearchDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
    public SearchDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public List<String> getServers(String searchKey) {
		System.out.println("In DAO : "+searchKey);
		String sql = "select host_name from ALL_SERVERS where HOST_NAME like ? and rownum < 10 order by host_name";
		System.out.println(sql);
		List<String> serverList = jdbcTemplate.queryForList(sql, new Object[] { searchKey+"%"}, String.class);
		System.out.println(serverList);
		preparedStmt(searchKey);
		return serverList;
	}
	
	@Override
	public boolean isValidServer(String server) {
		String sql = "select count(*) from ALL_SERVERS where host_name = ?";
		int count = jdbcTemplate.queryForObject( sql, new Object[] { server}, Integer.class);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Monitor> getCPUMonitors(String serverName) {
		String sql = "SELECT * FROM CPUMONITOR where HOST_NAME = ?";
		List<Monitor> list = this.jdbcTemplate.query(sql, new Object[] {serverName}, new MonitorMapper());
		return list;
	}
	
	@Override
	public String createCPUMonitor(MonitorRequest monitorRequest) {
		String result = "OK";
		String sql = "INSERT INTO CPUMONITOR (source, monitor_name, host_name, interval, condition, escal_type, escal_group, schedule, change_group) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String monitorName = MonitorUtils.constructMonitorName(monitorRequest);
		Object[] params = new Object[] {"vlrtp927", monitorName, monitorRequest.getHostname(), monitorRequest.getInterval(), monitorRequest.getCondition(),
				 monitorRequest.getEscalType(), monitorRequest.getEscalGroup(), monitorRequest.getSchedule(), monitorRequest.getChgGroup()};
		
		try {
			this.jdbcTemplate.update(sql, params);
		} catch (DataAccessException e) {
			System.out.println("Error while inserting");
			result = "Error while inserting";
		}
		
		
		return result;
	}
	
	
	@Override
	public void test() {
		System.out.println("************** Spring JDBC TEST****************");
		
		System.out.println("Here is a simple query for getting the number of rows in a relation:");
		String sql1 = "select count(*) from ALL_SERVERS";
		int rowCount = this.jdbcTemplate.queryForObject(sql1, Integer.class);
		System.out.println(rowCount);
		
		
		System.out.println("A simple query using a bind variable:");
		String sql2 = "select count(*) from ALL_SERVERS where host_name = ?";
		int countOfvos224664 = this.jdbcTemplate.queryForObject(sql2, Integer.class, "vos224664");
		System.out.println(countOfvos224664);
		
		System.out.println("A simple query using a bind variable as array object");
		String sql3 = "select count(*) from ALL_SERVERS where host_name = ?";
		String serverName = "vos224664";
		int count = jdbcTemplate.queryForObject( sql3, new Object[] { serverName }, Integer.class);
		System.out.println(count);
		
		System.out.println("A simple query using a bind variable as array objectssssss");
		String sql4 = "select count(*) from ALL_SERVERS where host_name = ? and cost_center = ?";
		String serverName1 = "vos224664";
		Integer costCenter = 83600;
		int count1 = jdbcTemplate.queryForObject( sql4, new Object[] { serverName1, costCenter }, Integer.class);
		System.out.println(count1);
		
		System.out.println("Querying for a String:");
		String sql5 = "select ESCAL_GROUP from ALL_SERVERS where host_name = ?";
		String escalGroup = this.jdbcTemplate.queryForObject(sql5, new Object[]{"vos224664"}, String.class);
		System.out.println(escalGroup);
		
	}
	

	private void preparedStmt(String searchKey) {
		System.out.println("In preparedStmt ################################");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "monitoring";
		String password = "monitoring";

		String sql = "select host_name from ALL_SERVERS where HOST_NAME like ?";
		Connection connection = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// STEP 3: Open a connection
			connection = DriverManager.getConnection(url, username, password);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, searchKey+"%");
			ResultSet rs = statement.executeQuery();

			// STEP 5: Extract data from result set
			System.out.println("########  HOST_NAME  ########");
			while (rs.next()) {
				String server  = rs.getString("HOST_NAME");				
				System.out.println(server);
			}

			// STEP 6: Clean-up environment
			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	
		
	}

	@Override
	public MovieSearchResult getMovieSearchResult(String searchKey) {
		return null;
	}

	

	

	

	/*@Override
	public MovieSearchResult getMovieSearchResult(String searchKey) {
		System.out.println("In DAO :: "+searchKey);

	    final String uriString = "https://api.themoviedb.org/3/search/movie";
	    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uriString);
	    builder.queryParam("api_key", "d272326e467344029e68e3c4ff0b4059");
	    builder.queryParam("language", "en-US");
	    builder.queryParam("query", searchKey);
	    
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<MovieSearchResult> result = restTemplate.exchange( builder.build().encode().toUri(), HttpMethod.GET, entity,  MovieSearchResult.class);
	   // ResponseEntity<String> result = restTemplate.exchange( builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);
	     System.out.println("******************RESULT*********************");
	    System.out.println(result);
		return result.getBody();
	}*/

	

	

}
