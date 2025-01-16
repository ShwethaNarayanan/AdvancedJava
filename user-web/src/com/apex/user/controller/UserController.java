package com.apex.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.apex.user.bo.UserBO;
import com.apex.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	UserBO userBO = null;
	
	@RequestMapping("/entryAddUser.do")
	public String entryAddUser(@ModelAttribute UserVO userVO) {
		return "person";
	}
	@RequestMapping("/processAddUser.do")
	public String processAddUser(@ModelAttribute UserVO userVO) {
		System.out.println("UserController:processAddUser():Start");
		// step1: reading
		System.out.println("First Name: " + userVO.getFirstName());
		System.out.println("Last Name: " + userVO.getLastName());
		System.out.println("Middle Name: " + userVO.getMiddleName());
		

		// Step2: Processing
		 userBO.addUsr(userVO);
		// Step3: response
		System.out.println("UserController:processAddUser():End");
		return "success";
	}
}
