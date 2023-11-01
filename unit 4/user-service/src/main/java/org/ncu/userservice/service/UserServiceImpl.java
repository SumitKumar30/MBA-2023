package org.ncu.userservice.service;

import org.ncu.userservice.dto.DepartmentDto;
import org.ncu.userservice.dto.ResponseDto;
import org.ncu.userservice.dto.UserDto;
import org.ncu.userservice.entity.User;
import org.ncu.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public ResponseDto getUser(Long userId) {
		ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);
        ResponseEntity<DepartmentDto> responseEntity = 
        		restTemplate.getForEntity("http://localhost:8080/api/departments/" + user.getDepartmentId(),
                DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();
        System.out.println(responseEntity.getStatusCode());
        
        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);
		return responseDto;
	}
	
	private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
