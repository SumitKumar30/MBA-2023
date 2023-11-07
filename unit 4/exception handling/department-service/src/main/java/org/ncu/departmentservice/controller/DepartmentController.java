package org.ncu.departmentservice.controller;

import org.ncu.departmentservice.entity.Department;
import org.ncu.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping(value = "/add")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		Department savedDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
		Department department = departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(department);
	}

}
