package org.ncu.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@Autowired
	private Environment env; 
	
	@GetMapping(path = "/admin")
	public String getDetails() {
		return "I am Admin: "+env.getProperty("local.server.port");
	}
}
