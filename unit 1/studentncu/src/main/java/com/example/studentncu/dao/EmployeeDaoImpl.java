package com.example.studentncu.dao;

import javax.activation.DataSource;

import com.example.studentncu.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "";
		jdbcTemplate.update(sql);
	}

	@Override
	public Employee fetchEmployeebyId(int empId) {
		// TODO Auto-generated method stub
		
		// RowMapper | ResultSetExtractor | BeanPropertyRowMapper
		return null;
	}

	@Override
	public void updateEmployee(int empId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee fetchEmployeebyName(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

}
