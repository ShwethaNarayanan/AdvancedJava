package com.apex.user.client;

import com.apex.user.dao.UserDAO;
import com.apex.user.vo.User;

public class UserClient {
	public static void main(String[] args) {
		User user = new User();
		user.setFirstName("AA");
		user.setLastName("AA");
		user.setMiddleName("AA");
		
		UserDAO userDAO = new UserDAO();
		userDAO.addUser(user);
	}
}
