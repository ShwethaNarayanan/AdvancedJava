package com.profiles.main.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.profiles.main.dao.StudentJPADAO;
import com.profiles.main.entities.Student;
import com.profiles.main.exceptions.CustomExceptions;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	public static final Logger log = LogManager.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentJPADAO studentjpadao;

	@Override
	public void saveStudent(Student student) {

		try {
			log.info("In saveStudent method - Service Impl: Start");
			studentjpadao.save(student);
			log.info("In saveStudent method - Service Impl : End");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomExceptions(HttpStatus.NOT_MODIFIED, e.getMessage());
		}

	}

	@Override
	public Student getStudentById(int id) {
		try {
			log.info("In saveStudent method - Service Impl: Start");
			Student student = studentjpadao.findById(id).orElse(null);
			if (student == null) {
				log.info("No record found in the database for the id");
			}
			return student;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new CustomExceptions(HttpStatus.NOT_MODIFIED, e.getMessage());
		}

	}

}
