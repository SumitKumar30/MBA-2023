package org.ncu.departmentservice.service;

import org.ncu.departmentservice.entity.Department;
import org.ncu.departmentservice.exception.RecordNotFoundException;
import org.ncu.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {

		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(Long departmentId) {
		
//		Department deptEntity = departmentRepository.findById(departmentId).orElseThrow(() -> new RecordNotFoundException("Customer details for customer[" + departmentId + "] does not exist"));
//
//		return deptEntity;
		return departmentRepository.findById(departmentId).orElseThrow(() -> new RecordNotFoundException("Department with id: "+departmentId+" is not present!!"));
	}

}
