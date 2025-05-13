package com.learn.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.main.dao.UserDao;
import com.learn.main.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;
	
	public List<User> getAllUsers(){
		return userdao.findAll();
	}
	
	public User getUserByID(int id) {
		return userdao.findById(id);
	}

	public User saveUser(User user) {
		int save = userdao.saveUser(user);
		System.out.println(save);
		System.out.println(user);
		if(save > 0) {
			return user;
		}
		return null;
	}
}
