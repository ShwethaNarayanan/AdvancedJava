package com.learn.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.learn.beans.User;

public class DaoService {
	
	public User validateUser(User user, JdbcTemplate jdbcTemp) {
		
		String query = "SELECT * FROM USER WHERE username = ? and password = ?";
		
		try {
			user = jdbcTemp.queryForObject(query, new UserRowMapper(), user.getUsername(), user.getPassword());

		}catch(Exception e) {
			e.printStackTrace();
			return user;
		}
		return user;
		
	}

}
