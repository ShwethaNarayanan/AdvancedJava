package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.bo.UserBO;
import com.service.vo.UserVO;

@RestController
public class UserRestController {
	
	@Autowired
	private UserBO userbo;
	
	@GetMapping("/")
	public String getUser(){
		return "Welcome";
		}
	
	@PostMapping(value = "/saveuser")
	public UserVO saveUser(@RequestBody UserVO userVO) {
		System.out.println(userVO.getFirstName());
		userbo.addUsr(userVO);
		return userVO;
	}
	
	@GetMapping("/getuser/{id}")
	public UserVO getUserById(@PathVariable("id") int id){
		return userbo.getUsr(id);		
	}
}
