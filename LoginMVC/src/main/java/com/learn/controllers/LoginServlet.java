package com.learn.controllers;

import java.io.IOException;

import com.learn.bean.User;
import com.learn.service.UserService;
import com.learn.util.UserUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(description = "Login Servlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String inputNull = UserUtil.validateUser(request);
		HttpSession session = request.getSession();
		User user = new User();

		// Set the username and password fields in the User Bean
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		UserService service = new UserService();
		String invalidUser = service.verifyPopulateUser(user);

		if (invalidUser == null) {
			session.setAttribute("fname", user.getFname());
			session.setAttribute("lname", user.getLname());
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}

	}

}
