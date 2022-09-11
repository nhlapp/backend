package com.nhl.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhl.backend.models.User;
import com.nhl.backend.repositories.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;	
	
	@PostMapping("/getcurrentuser")
	public User getCurrentUser(Authentication auth) {
		return this.userRepository.findByUsername(auth.getName());
	}
}
