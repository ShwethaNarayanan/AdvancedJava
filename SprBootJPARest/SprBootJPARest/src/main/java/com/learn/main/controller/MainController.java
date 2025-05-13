package com.learn.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.main.entity.User;
import com.learn.main.service.UserService;

@RestController
public class MainController {
	
	@Autowired
	private UserService userService; 
	
	@GetMapping("/getusers")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/getuser/{id}")
	public User getUserById(@PathVariable int id){
		return userService.getUserByID(id);		
	}
	
	@PostMapping("/saveuser")
	public User saveUser(User user) {
		System.out.println(user);
		return userService.saveUser(user);
	}
	

}
