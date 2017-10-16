package com.capcom.monitoring.model;

public class Monitor {
	
	private Integer monitorId;
	private String source;
	private String monitorName;
	private String hostName;
	private String interval;
	private String condition;
	private String escalType;
	private String escalGroup;
	private String schedule;
	private String changeGroup;
	
	
	public Integer getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(Integer monitorId) {
		this.monitorId = monitorId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getMonitorName() {
		return monitorName;
	}
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getEscalType() {
		return escalType;
	}
	public void setEscalType(String escalType) {
		this.escalType = escalType;
	}
	public String getEscalGroup() {
		return escalGroup;
	}
	public void setEscalGroup(String escalGroup) {
		this.escalGroup = escalGroup;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getChangeGroup() {
		return changeGroup;
	}
	public void setChangeGroup(String changeGroup) {
		this.changeGroup = changeGroup;
	}
	
	

}
