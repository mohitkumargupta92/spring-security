package com.spring.security.resource;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class HelloResource {
	
	@GetMapping("/hello")
	public  String helloWorld(@AuthenticationPrincipal final UserDetails userDetails){
		System.out.println("User Name "+userDetails.getUsername()+" password "+userDetails.getPassword());
		
		return "Welcome!! to the World of Mohit";
	}
	
	@GetMapping("/bye")
	public  String byeWorld(@AuthenticationPrincipal final UserDetails userDetails){
		System.out.println("User Name "+userDetails.getUsername()+" password "+userDetails.getPassword());
		
		return "Good Bye!";
	}

}
