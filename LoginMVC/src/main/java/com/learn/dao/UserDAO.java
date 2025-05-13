package com.learn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learn.bean.User;

public class UserDAO {

	public User retrieveUser(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query = "SELECT * FROM USER WHERE username = ? and password = ?";

			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");
					PreparedStatement ps = con.prepareStatement(query);) {
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					user.setFname(rs.getString(3));
					user.setLname(rs.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return user;

	}

	public String registration(User user) {
		String userExists = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query = "SELECT * FROM USER WHERE username = ?";

			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");
					PreparedStatement ps = con.prepareStatement(query);) {
				ps.setString(1, user.getUsername());
				ResultSet rs = ps.executeQuery();
				if(rs.next() == false) {
					query = "INSERT INTO user VALUES(?,?,?,?)";
					PreparedStatement ps1 = con.prepareStatement(query);
					ps1.setString(1, user.getUsername());
					ps1.setString(2, user.getPassword());
					ps1.setString(3, user.getFname());
					ps1.setString(4, user.getLname());
					ps1.executeUpdate();
				}else {
					userExists = "User already exists!";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return userExists;
	}

}
