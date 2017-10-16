package com.capcom.monitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capcom.monitoring.dao.JDBCTestDao;

@Service
public class JDBCTestServiceImpl implements JDBCTestService {
	
	@Autowired
	JDBCTestDao jdbcTestDao;

	@Override
	public String jdbcTest() {
		return jdbcTestDao.jdbcTest();
	}
	
	@Override
	public String jdbcTestSpring() {
		return jdbcTestDao.jdbcTestSpring();
	}
	
	@Override
	public void insert(){
		jdbcTestDao.insert();
	}

}
