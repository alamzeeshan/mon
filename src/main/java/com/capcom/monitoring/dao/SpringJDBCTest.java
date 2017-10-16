package com.capcom.monitoring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJDBCTest implements CommandLineRunner{
	
private final JdbcTemplate jdbcTemplate;
	
	@Autowired
    public SpringJDBCTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public void run(String... args) throws Exception {
		
		
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from ALL_SERVERS", Integer.class);
		System.out.println(rowCount);
	}

}
