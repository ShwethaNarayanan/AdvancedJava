package com.profiles.main.service;

import com.profiles.main.entities.Student;

public interface StudentService {

	public void saveStudent(Student student);
	
	public Student getStudentById(int id);
}
