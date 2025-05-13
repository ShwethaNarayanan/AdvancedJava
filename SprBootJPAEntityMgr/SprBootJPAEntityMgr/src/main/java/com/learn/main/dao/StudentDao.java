package com.learn.main.dao;

import java.util.List;

import com.learn.main.entities.Student;

public interface StudentDao {
	
	//Insert - save()
	public boolean saveStudent(Student std);
	
	//Select - by ID
	public Student find(int id);
	
	//Select all
	public List<Student> findAll();
	
	
	public boolean updateStudent(int id, String lname);
	
	//Delete by ID
	public boolean deleteStudent(int id);

}
