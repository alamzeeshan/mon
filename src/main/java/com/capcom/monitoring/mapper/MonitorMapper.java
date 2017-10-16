package com.capcom.monitoring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capcom.monitoring.model.Monitor;

public class MonitorMapper implements RowMapper<Monitor> {

	@Override
	public Monitor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Monitor monitor = new Monitor();
		monitor.setMonitorId(rs.getInt("MONITOR_ID"));
		monitor.setSource(rs.getString("SOURCE"));
		monitor.setMonitorName(rs.getString("MONITOR_NAME"));
		monitor.setHostName(rs.getString("HOST_NAME"));
		monitor.setInterval(rs.getString("INTERVAL"));
		monitor.setCondition(rs.getString("CONDITION"));
		monitor.setEscalType(rs.getString("ESCAL_TYPE"));
		monitor.setEscalGroup(rs.getString("ESCAL_GROUP"));
		monitor.setSchedule(rs.getString("SCHEDULE"));
		monitor.setChangeGroup(rs.getString("CHANGE_GROUP"));
		return monitor;
	}

}
