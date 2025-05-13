package com.learn;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Studentjdbc")
public class StudentServletJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		//init() is called exactly once when the Servlet is called. init(config) helps in initializing connection url username etc.
		// which can be used across all the Servlets and web pages. Using init parameter limits the scope to that particular servlet
		try {
			String conURL = config.getServletContext().getInitParameter("conURL");
			String username = config.getServletContext().getInitParameter("username");
			String password = config.getServletContext().getInitParameter("password");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(conURL, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO Student VALUES(?,?,?,?,?)");			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setInt(3, age);
			ps.setString(4, email);
			ps.setString(5, gender);
			
			int eUpdate = ps.executeUpdate();
			
			if(eUpdate > 0) {
				response.setContentType("text/HTML");
				response.getWriter().append("<h3 style = 'color:green'> Student record created successfully </h3><br>");				
				RequestDispatcher rd = request.getRequestDispatcher("createStudent.jsp");
				rd.include(request, response);

			}
			else {
				response.setContentType("text/HTML");
				response.getWriter().append("<h3 style = 'color:red'> Student record not created </h3><br>");				
				RequestDispatcher rd = request.getRequestDispatcher("createStudent.jsp");
				// include() helps to combine text( using print writer) and web page(jsp/html) content
				rd.include(request, response);				
			}

			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			response.setContentType("text/HTML");
			response.getWriter().append("<h3 style = 'color:red'> Exception occured :" + e.getMessage()+ "</h3><br>");
			
			RequestDispatcher rd = request.getRequestDispatcher("createStudent.jsp");
			rd.include(request, response);
		}
		

	}
	@Override
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
