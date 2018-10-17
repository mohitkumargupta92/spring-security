package com.spring.security.resource;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/hello")
public class HelloResource {
	
	@GetMapping
	public  String helloWorld(@AuthenticationPrincipal final UserDetails userDetails){
		System.out.println("User Name "+userDetails.getUsername()+"password "+userDetails.getPassword());
		
		return "Welcome!! to the World of Mohit";
	}

}
