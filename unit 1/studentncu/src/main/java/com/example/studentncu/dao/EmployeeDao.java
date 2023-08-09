package com.example.studentncu.dao;

import com.example.studentncu.entity.Employee;

public interface EmployeeDao {
	public void insertEmployee(Employee emp);
	
	public Employee fetchEmployeebyId(int empId);
	
	public void updateEmployee(int empId);
	
	public void deleteEmployee(int empId);
	
	public Employee fetchEmployeebyName(String empName);
}
