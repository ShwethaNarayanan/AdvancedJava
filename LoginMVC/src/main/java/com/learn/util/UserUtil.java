package com.learn.util;

import com.learn.bean.User;

import jakarta.servlet.http.HttpServletRequest;

public class UserUtil {

	public static String validateUser(HttpServletRequest request) {
		
		String inputNull = null;
		
		User user = new User();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.isEmpty() || password.isEmpty()) {
			inputNull = "Username or password cannot be empty!";
		}
		
		return inputNull;
	}

}
