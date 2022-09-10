package com.nhl.backend.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhl.backend.models.User;
import com.nhl.backend.repositories.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {
	
	private UserRepository userRepository;	
	
	@PostMapping("/login")
	public User login(@RequestParam Map<String, String> params) {
		User user = this.userRepository.findByUsername(params.get("username"));
		if (user.getPassword().equals(params.get("password"))) {
			return user;
		} 
		
		return null;
	}
	
}
