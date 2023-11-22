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
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	  @Autowired private RestTemplate restTemplate;
	 
		/*
		 * @Autowired private WebClient webClient;
		 */
	
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
		  restTemplate.getForEntity("http://localhost:8080/api/departments/" +
		  user.getDepartmentId(), DepartmentDto.class);
		 
		/*
		 * DepartmentDto departmentDto = webClient.get()
		 * .uri("http://localhost:8080/api/departments/" + user.getDepartmentId())
		 * .retrieve() .bodyToMono(DepartmentDto.class) .block();
		 */
		
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

	@Override
	public DepartmentDto saveDepartment(DepartmentDto dept) {
//		DepartmentDto deptDto = new DepartmentDto((long) 102, "IT", "IITD", "IT01");
		DepartmentDto deptDtoStored = restTemplate.postForObject("http://localhost:8080/api/departments/add", dept, DepartmentDto.class);
		return deptDtoStored;
	}

}
