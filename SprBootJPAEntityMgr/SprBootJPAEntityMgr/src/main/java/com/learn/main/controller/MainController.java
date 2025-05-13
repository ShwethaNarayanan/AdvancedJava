package com.learn.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.main.entities.Student;
import com.learn.main.service.StudentService;

@Controller
public class MainController {
	
	@Autowired
	private StudentService stdService;
	
	@GetMapping("/regPage")
	public String openRegPage() {
		return "registration";
	}
	
	@PostMapping("/register")
	public String registration(@ModelAttribute Student student, Model model) {
		
		String page;
		if(stdService.saveStudent(student)) {
			model.addAttribute("fname", student.getFname());
			model.addAttribute("lname", student.getLname());
			page = "welcome";
		}
		else {
			page = "registration";
		}
		return page;
		
	}
}
