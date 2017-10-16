package com.capcom.monitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capcom.monitoring.dao.SearchDAO;
import com.capcom.monitoring.model.Monitor;
import com.capcom.monitoring.model.MonitorRequest;
import com.capcom.monitoring.model.MovieSearchResult;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	SearchDAO searchDAO;
	
	@Override
	public MovieSearchResult getMovieSearchResult(String searchKey) {		
		return searchDAO.getMovieSearchResult(searchKey);
	}

	@Override
	public List<String> getServers(String searchKey) {
		return searchDAO.getServers(searchKey);
	}

	@Override
	public boolean isValidServer(String server) {		
		return searchDAO.isValidServer(server);
	}

	@Override
	public void test() {
		searchDAO.test();
		
	}

	@Override
	public List<Monitor> getCPUMonitors(String serverName) {
		return searchDAO.getCPUMonitors(serverName);
	}

	@Override
	public String createCPUMonitor(MonitorRequest monitorRequest) {
		return searchDAO.createCPUMonitor(monitorRequest);
	}

	

}
