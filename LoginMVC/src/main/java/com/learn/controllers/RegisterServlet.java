package com.learn.controllers;

import java.io.IOException;

import com.learn.bean.User;
import com.learn.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();

		// Set the username and password fields in the User Bean
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setFname(request.getParameter("fname"));
		user.setLname(request.getParameter("lname"));

		UserService service = new UserService();
		String userExists = service.registerUser(user);

		if (userExists == null) {
			response.setContentType("text/html");
			response.getWriter().append("<h3 style = 'color:green'> User created successfully ! </h3><br>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}else {
			response.setContentType("text/html");
			response.getWriter().append("<h3 style = 'color:red'> User already exists ! </h3><br>");
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			rd.include(request, response);
		}
	}

}
