package org.ncu.fsb_demo_jpa.dao;

import java.util.List;

import org.ncu.fsb_demo_jpa.entity.Employee;

public interface EmployeeDao {
	public void insertRecord(Employee emp);
	public Employee findById(int id);
	public Employee findByName(String name);
	public List<Employee> findAllRecords();
	public void updateRecord(int id);
	public void deleteRecord(int id);
}
