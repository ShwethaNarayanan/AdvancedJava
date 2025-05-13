package com.learn.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.main.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserJPADao implements UserDao {

	@Autowired
	EntityManager entityMgr;

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = entityMgr.createQuery("select user FROM User user", User.class);
		return query.getResultList();
	}

	@Override
	public User findById(int id) {
		User user = new User();
		user = entityMgr.find(User.class, id);
		return user;
	}

	@Override
	public int saveUser(User user) {
		int save;
		try {
			entityMgr.persist(user);
			save = 1;
			
		} catch (Exception e) {
			save = 0;
		}
		return save;
	}

}
