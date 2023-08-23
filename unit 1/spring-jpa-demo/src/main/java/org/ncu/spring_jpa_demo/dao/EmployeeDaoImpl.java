package org.ncu.spring_jpa_demo.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.ncu.spring_jpa_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insertEmployeeRecord(Employee emp) {
		entityManager.persist(emp);
	}

	@Override
	public Employee fetchEmployeebyId(int empId) {
		// TODO Auto-generated method stub
		// RowMapper | ResultSetExtractor | BeanPropertyRowMapper
		entityManager.find(null, entityManager);
		return null;
	}

	@Override
	public Employee fetchEmployeebyName(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployeeRecord(int empId) {
		// TODO Auto-generated method stub
		entityManager.setProperty(null, entityManager);
	}

	@Override
	public void deleteEmployeeRecord(int empId) {
		// TODO Auto-generated method stub
//		entityManager.remove(emp);
	}

}
