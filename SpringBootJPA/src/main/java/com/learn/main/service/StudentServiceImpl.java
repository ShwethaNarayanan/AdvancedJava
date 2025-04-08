package com.learn.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.main.entities.Students;
import com.learn.main.repositoy.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository stdRepo;

	@Override
	@Transactional
	public boolean saveStudent(Students std) {

		boolean status;
		try {
			stdRepo.save(std);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}

	@Override
	@Transactional
	public Students find(int id) {
		Optional<Students> optional = stdRepo.findById(id);
		if (!optional.isEmpty()) {
			return optional.get();
		}
		return null;
	}

	@Override
	@Transactional
	public List<Students> findAll() {
		List<Students> std_list = stdRepo.findAll();
		return std_list;
	}

	@Override
	@Transactional
	public boolean updateStudent(int id, float marks) {
		// First find the record so that the other field values do not get null while
		// updating a value
		Students std = find(id);
		if (std != null) {
			std.setMarks(marks);
			stdRepo.save(std);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteStudent(int id) {

		try {
			stdRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
