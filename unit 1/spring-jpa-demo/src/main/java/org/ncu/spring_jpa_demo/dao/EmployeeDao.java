package org.ncu.spring_jpa_demo.dao;

import org.ncu.spring_jpa_demo.entity.Employee;

public interface EmployeeDao {
	public void insertEmployeeRecord(Employee emp);
	public Employee fetchEmployeebyId(int empId);
	public Employee fetchEmployeebyName(String empName);
	public void updateEmployeeRecord(int empId);
	public void deleteEmployeeRecord(int empId);
}
