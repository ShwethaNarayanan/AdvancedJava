package com.test;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WebServlet1 extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) {

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");

		try {
			res.getWriter().append("Good morning, " + fname + " " + lname + "!").close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
