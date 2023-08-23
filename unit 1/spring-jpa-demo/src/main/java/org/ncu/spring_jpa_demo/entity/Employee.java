package org.ncu.spring_jpa_demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class Employee {
	// class members
	@Id
	@Column(name = "emp_id", length = 10)
	private int empId;
	@Column(name = "emp_name", nullable =  false, length = 20)
	private String empName;
	@Column(name = "emp_address", nullable = false, length = 50)
	private String empAddress;
	@Column(name = "emp_email", unique = false)
	private String empEmail;
	@Column(name = "emp_salary", nullable = true)
	private double empSalary;
	
	// default constructor
	Employee(){
		
	}
	
	// parameterized constructor
	public Employee(int empId, String empName, String empAddress, String empEmail, Double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empEmail = empEmail;
		this.empSalary = empSalary;
	}
	
	
	// getters & setters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empEmail="
				+ empEmail + ", empSalary=" + empSalary + "]";
	}
	
}
