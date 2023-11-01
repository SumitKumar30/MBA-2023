package org.ncu.departmentservice.service;

import org.ncu.departmentservice.entity.Department;

public interface DepartmentService {
	Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}
