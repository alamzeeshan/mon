package com.capcom.monitoring.model;

public class MonitorRequest {
	
	
	
	private String hostname;
	private String condition;
	private String interval;
	private String escalType;
	private String escalGroup;
	private String schedule;
	private String chgGroup;
	
	
	
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
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
	public String getChgGroup() {
		return chgGroup;
	}
	public void setChgGroup(String chgGroup) {
		this.chgGroup = chgGroup;
	}
	
	@Override
	public String toString() {
		return "MonitorRequest [hostname=" + hostname + ", condition=" + condition + ", interval=" + interval
				+ ", escalType=" + escalType + ", escalGroup=" + escalGroup + ", schedule=" + schedule + ", chgGroup="
				+ chgGroup + "]";
	}

}
