package com.capcom.monitoring.dao;

import java.util.List;

import com.capcom.monitoring.model.Employee;

public interface JDBCTestDao {

	String jdbcTest();

	String jdbcTestSpring();

	List<Employee> getAllEmployees();

	void insert();

}
