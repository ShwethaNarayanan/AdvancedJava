package com.learn.main.service;

import java.util.List;

import com.learn.main.entities.Students;

public interface StudentService {
	
	//Insert - save()
	public boolean saveStudent(Students std);
	
	//Select - by ID
	public Students find(int id);
	
	//Select all
	public List<Students> findAll();
	
	//Update - Find by ID then Save
	public boolean updateStudent(int id, float marks);
	
	//Delete by ID
	public boolean deleteStudent(int id);
	

}
