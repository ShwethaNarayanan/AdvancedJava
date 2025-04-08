package com.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.LoginDTO;
import com.user.dto.RegisterDTO;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String getUserByName() {
		return "User";
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
		if (userService.existsByUsername(registerDTO.getUsername())) {
			return new ResponseEntity<>("Username already exists!", HttpStatus.BAD_REQUEST);
		}
		userService.saveUser(registerDTO);		
		return new ResponseEntity<>("User created successfully!", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
		try {
			String token = userService.authenticateUser(loginDTO);
			return new ResponseEntity<>(token, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Authentication failed!", HttpStatus.BAD_REQUEST);
		}	
		
	}
}
