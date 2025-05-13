package com.learn.main.dao;

import java.util.List;

import com.learn.main.entity.User;

public interface UserDao {
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public int saveUser(User user);

}
