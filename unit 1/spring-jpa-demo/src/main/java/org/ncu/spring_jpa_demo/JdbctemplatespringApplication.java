package org.ncu.spring_jpa_demo;

import org.ncu.spring_jpa_demo.dao.EmployeeDao;
import org.ncu.spring_jpa_demo.dao.EmployeeDaoImpl;
import org.ncu.spring_jpa_demo.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JdbctemplatespringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbctemplatespringApplication.class, args);
	
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDao empDao) {
		return runner -> callEmployee(empDao);
	}
	
	private void callEmployee(EmployeeDao empDao) {
		System.out.println("Save operation initiated!!!");
		Employee empObj = new Employee(102, "Tom", "Delhi", "del@xyz", 500000.00);
		empDao.insertEmployeeRecord(empObj);
		System.out.println("Employee record inserted successfully!!!");
	}	
}
