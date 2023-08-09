package com.example.studentncu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class StudentncuApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentncuApplication.class, args);
		System.out.println("Hello World");
	}

}
