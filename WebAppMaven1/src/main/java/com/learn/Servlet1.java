package com.learn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO PERSON VALUES (6,'Roy','Rima', 'Kolkata')");
			response.getWriter().append("Record successfully added to Person table!");
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

}
