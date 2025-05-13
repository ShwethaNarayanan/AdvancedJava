package com.learn.main.service;

import java.util.List;

import com.learn.main.entity.User;

public interface UserService {
	
	//Insert - save()
	public boolean saveUser(User user);
	
	//Select - by ID
	public User find(int id);
	
	//Select all
	public List<User> findAll();
	
	//Update - Find by ID then Save
	public boolean updateUser(int id, String email);
	
	//Delete by ID
	public boolean deleteUser(int id);

}
