package org.ncu.userservice.service;

import org.ncu.userservice.dto.DepartmentDto;
import org.ncu.userservice.dto.ResponseDto;
import org.ncu.userservice.entity.User;

public interface UserService {
	User saveUser(User user);

    ResponseDto getUser(Long userId);
    
    DepartmentDto saveDepartment(DepartmentDto dept);
}
