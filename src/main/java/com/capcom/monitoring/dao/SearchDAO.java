package com.capcom.monitoring.dao;

import java.util.List;

import com.capcom.monitoring.model.Monitor;
import com.capcom.monitoring.model.MonitorRequest;
import com.capcom.monitoring.model.MovieSearchResult;

public interface SearchDAO {

	MovieSearchResult getMovieSearchResult(String searchKey);

	List<String> getServers(String searchKey);

	boolean isValidServer(String server);

	void test();

	List<Monitor> getCPUMonitors(String serverName);

	String createCPUMonitor(MonitorRequest monitorRequest);

}
