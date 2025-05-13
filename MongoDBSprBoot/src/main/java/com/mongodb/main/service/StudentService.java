package com.mongodb.main.service;

import com.mongodb.main.document.Student;

public interface StudentService {
	
	public void saveStudent(Student student);
	
	public Student getStudentById(int id);
	
	public void updateStudent(int id, String lname, int age);
	
	public void deleteStudent(int id);

}
