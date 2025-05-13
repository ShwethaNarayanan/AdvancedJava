package com.learn.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.main.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentJPADao implements StudentDao {

	@Autowired
	private EntityManager entityMgr;

	@Override
	public boolean saveStudent(Student std) {
		try {
			entityMgr.persist(std);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Student find(int id) {
		Student std = entityMgr.find(Student.class, id);
		return std;
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = entityMgr.createQuery("select std FROM Student std", Student.class);
		// entityMgr.createNativeQuery("select * from studentdb", Student.class).getResultList();
		return query.getResultList();
	}

	@Override
	public boolean updateStudent(int id, String lname) {
		try {
			Student std = entityMgr.find(Student.class, id);
			std.setLname(lname);
			entityMgr.merge(std);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int id) {

		try {
			Student std = entityMgr.find(Student.class, id);
			entityMgr.remove(std);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
