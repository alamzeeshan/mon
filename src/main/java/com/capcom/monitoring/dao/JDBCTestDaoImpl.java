package com.capcom.monitoring.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.capcom.monitoring.model.Employee;

@Component
public class JDBCTestDaoImpl implements JDBCTestDao {
	

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
    public JDBCTestDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	@Override
	public void insert() {
		String sql = "INSERT INTO ALL_SERVERS " +
				"(HOST_NAME, ESCAL_GROUP, COST_CENTER) VALUES (?, ?, ?)";
		
		String[] escalArray = {"apm","ftgei","click2compute","itecalm","ftgops","itecudeploy","itecstash","akamai"
				+ "ngcc","openstack","citrix","oltx","netbenefits","coreops","seiops"};
		
		int[] costarray = {14300, 23400, 34400,12300,45400,96700,83600,57500,95900,34500,56500,56700,23900,39800};


		int count = 224400;
		System.out.println("########Inserting#######");
		for (int i =0; i < 500; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 13 + 1);
			String hostname = "vos"+count;
			count++;
			
			System.out.println(hostname +"\t"+costarray[randomNum] + "\t"+escalArray[randomNum]);
			jdbcTemplate.update(sql, new Object[] { hostname,
					escalArray[randomNum], costarray[randomNum]
				});
		}
	}
	
	
	@Override
	public String jdbcTestSpring() {
		System.out.println("In spring jdbcTest ################################");
		String query = "SELECT EMPNO FROM EMP WHERE JOB ='SALESMAN'";
		List<Integer> list =  jdbcTemplate.queryForList(query, Integer.class);
		System.out.println(list);
		return list.toString();
	}

	@Override
	public String jdbcTest() {
		System.out.println("In jdbcTest ################################");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "monitoring";
		String password = "monitoring";

		String sql = "SELECT EMPNO FROM EMP WHERE JOB ='SALESMAN'";
		Connection connection = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// STEP 3: Open a connection
			connection = DriverManager.getConnection(url, username, password);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			// STEP 5: Extract data from result set

			while (rs.next()) {
				int empNo  = rs.getInt("EMPNO");
				System.out.println("########  EMPNO  ########");
				System.out.println(empNo);
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

		return "Connected";
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("In jdbcTest ################################");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "monitoring";
		String password = "monitoring";

		String sql = "SELECT * FROM EMP";
		List<Employee> empList = null;
		Connection connection = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// STEP 3: Open a connection
			connection = DriverManager.getConnection(url, username, password);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(sql);

			// STEP 5: Extract data from result set
			empList = new ArrayList<>();
			
			while (rs.next()) {
				Integer empNo = rs.getInt("EMPNO");
				String empName = rs.getString("ENAME");
				String job = rs.getString("JOB");	
				Integer managerId = rs.getInt("MGR");;	
				Date hireDate = rs.getDate("HIREDATE");	
				Double salary = rs.getDouble("SAL");
				Integer deptNo = rs.getInt("DEPTNO");
				
				
				Employee emp = new Employee();
				emp.setEmpNo(empNo);
				emp.setEmpName(empName);
				emp.setJob(job);
				emp.setManagerId(managerId);
				emp.setHireDate(hireDate);
				emp.setSalary(salary);
				emp.setDeptNo(deptNo);
				
				empList.add(emp);
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

		return empList;
	}
	
	

    

}
