package org.ncu.app.controllers;

import javax.validation.Valid;

import org.ncu.app.dto.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskService {
	
	@Autowired
	private Environment env;
	
	@PostMapping(path = "/addtask", consumes= {
			MediaType.APPLICATION_JSON_VALUE
	}, produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<Task> addTask(@Valid @RequestBody Task task) {
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}

	@GetMapping(path = "/task/{taskid}")
	public String getTask(@PathVariable String taskid) {
		return "Task Id: " + taskid+" running at port: "+env.getProperty("local.server.port");
	}

	@GetMapping(path = "/task2")
	public String getTask2(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "name", defaultValue = "A Task", required = false) String name) {
		return "Task Id: " + id + " Name: " + name;
	} 
}
