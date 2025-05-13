package com.learn.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.main.entity.User;
import com.learn.main.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/regPage")
	public String openRegPage() {
		return "registration";
	}
	
	@PostMapping("/register")
	public String registration(@ModelAttribute User user, Model model) {
		
		String page;
		if(userService.saveUser(user)) {
			model.addAttribute("name", user.getName());
			page = "welcome";
		}
		else {
			page = "registration";
		}
		return page;
		
	}
}
