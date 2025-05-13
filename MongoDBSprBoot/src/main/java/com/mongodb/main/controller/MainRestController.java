package com.mongodb.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.main.document.Student;
import com.mongodb.main.exceptions.CustomExceptions;
import com.mongodb.main.service.StudentService;

@RestController
public class MainRestController {
	
	@Autowired
	private StudentService stdservice;
	
	@GetMapping("/")
	public String getWelcome() {
		return "Welcome";
	}

	@PostMapping("/savestudent")
	public String saveStudent(@RequestBody Student student) {
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
	
	@PutMapping("updatestudent/{id}/{lname}/{age}")
	public ResponseEntity<String> updateStudentbyId(@PathVariable("id") int id,
									@PathVariable("lname") String lname,
									@PathVariable("age") int age) {
		try {
			stdservice.updateStudent(id, lname, age);
			return ResponseEntity.ok("Update successful!");
		}catch(Exception e) {
			throw new CustomExceptions(HttpStatus.NOT_FOUND, "No Student found in the database for the id.");
		}
		
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		stdservice.deleteStudent(id);
		return "Student deleted";
	}
}
