package com.spring.security.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/hello")
public class HelloResource {
	
	@GetMapping
	public  String helloWorld(){
		return "Welcome!! to the World of Mohit";
	}

}
