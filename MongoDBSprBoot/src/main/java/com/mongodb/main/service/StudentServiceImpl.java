package com.mongodb.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.main.dao.StudentDAO;
import com.mongodb.main.document.Student;
import com.mongodb.main.exceptions.CustomExceptions;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO stdDAO;
	
	@Override
	public void saveStudent(Student student) {
		
		stdDAO.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		Student student = stdDAO.findById(id).orElse(null);
		return student;
	}

	@Override
	public void updateStudent(int id, String lname, int age) throws CustomExceptions{
		Student student = getStudentById(id);
		if(student != null) {
			student.setLname(lname);
			student.setAge(age);
			stdDAO.save(student);
		}else {
			throw new CustomExceptions(HttpStatus.NOT_FOUND, "No Student found in database for the id");
		}
	}

	@Override
	public void deleteStudent(int id) {
		stdDAO.deleteById(id);
	}
	

}
