package org.ncu.fsb_demo_jpa;

import java.util.List;

import org.ncu.fsb_demo_jpa.dao.EmployeeDao;
import org.ncu.fsb_demo_jpa.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FsbDemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsbDemoJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDao empDao) {
		return runner -> callEmployee(empDao);
	}
	
	private void callEmployee(EmployeeDao empDao) {
		
		/*
		 * System.out.println("Save operation initiated!!!"); Employee empObj1 = new
		 * Employee("Rahul", "Delhi", "paul@aol.com", 50000000.00); Employee empObj2 =
		 * new Employee("Max", "Chicago", "rahul@aol.com", 50000000.00);
		 * empDao.insertRecord(empObj1); empDao.insertRecord(empObj2);
		 * System.out.println("Record saved Successfully!!");
		 */
		 
//		System.out.println();
		/*
		 * Employee e = empDao.findByName("Sunil"); if(e != null) {
		 * System.out.println("Record Found!!!"); System.out.println(e); }else {
		 * System.out.println("Record not Found!!!!"); }
		 */
		
		System.out.println("========= PRINTING RECORDS IN DESC ORDER BY NAME");
		
		List<Employee> empNames = empDao.findByNameDesc();
		for(Employee emp : empNames) {
			System.out.println(emp);
		}
		
		System.out.println("=========== Find a record using address=========");
		System.out.println(empDao.findByAddress("Toronto"));
		
		System.out.println("=========== Fetching all Employee Records ============");
		
		List<Employee> list = empDao.findAllRecords();
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}	

}
