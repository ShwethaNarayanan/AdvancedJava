package com.profiles.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.profiles.main.entities.Student;
import com.profiles.main.exceptions.CustomExceptions;
import com.profiles.main.service.StudentService;

@RestController
public class MainRestController {
	
	@Autowired
	private StudentService stdservice;
	
	
	@GetMapping("/")
	public String getWelcome() {
		return "Welcome";
	}
	
	@PostMapping("/savestudent")
	public String saveUser(@RequestBody Student student) {
		stdservice.saveStudent(student);
		return "Saved Student";
	}

	@GetMapping("/getstudentbyid/{id}")
	public ResponseEntity<Student> getStudentbyId(@PathVariable("id") int id) {
		 Student student = stdservice.getStudentById(id);
		 if(student == null) {
			 throw new CustomExceptions(HttpStatus.NOT_FOUND, "No Student found in the database for the id.");
		 }else {
			 return ResponseEntity.ok(student);
		 }
	}
}
