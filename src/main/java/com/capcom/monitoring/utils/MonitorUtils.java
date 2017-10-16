package com.capcom.monitoring.utils;

import com.capcom.monitoring.model.MonitorRequest;

public class MonitorUtils {
	
	
	public static String constructMonitorName(MonitorRequest monitorRequest) {
		String monitorName = bracketed(monitorRequest.getHostname())+"[CPU][SS]"+bracketed(monitorRequest.getCondition())+"[Error]";
		return monitorName;
	}
	
	private static String bracketed(String value) {
		return "["+value+"]";
	}

}
