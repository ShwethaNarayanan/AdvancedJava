package com.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCAssign1 {

	public static void main(String[] args) {

		try {
			//The Driver class is loaded and the static block of Driver class is executed. Driver Manager registers the Driver in the static block.
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection is an interface. get connection method is implemented in DriverManager class(static method).
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO PERSON VALUES (1,'Iyer', 'Ram', 'Delhi')");
			System.out.println("Record successfully added to Person table!");
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
