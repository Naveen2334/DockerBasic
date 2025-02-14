package com.example.Docker_Demo_Learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerDemoController {
	
	
	@GetMapping("/dockerDemo")
	public String getDemo() {
		return "Spring Boot is Dockerised Succefully";
		
	}

}
