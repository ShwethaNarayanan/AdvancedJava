package com.learn.service;

import com.learn.bean.User;
import com.learn.dao.UserDAO;

public class UserService {
	
	UserDAO dao = new UserDAO();
	public String verifyPopulateUser(User user) {
		
		String invalidUser = null;
		user = dao.retrieveUser(user);
		if(user.getUsername() == null) {
			invalidUser = "Invalid User credentials.";
		}
		return invalidUser;
	}

	public String registerUser(User user) {
		
		String userExists = null;
		userExists = dao.registration(user);
		return userExists;
	}

}
