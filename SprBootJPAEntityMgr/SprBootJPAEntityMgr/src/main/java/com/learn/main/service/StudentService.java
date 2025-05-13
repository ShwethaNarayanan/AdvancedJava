package com.learn.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.main.dao.StudentDao;
import com.learn.main.entities.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentdao;
	
	public boolean saveStudent(Student std) {
		return studentdao.saveStudent(std);
		
	}

}
