package com.user.service;

import com.user.dto.LoginDTO;
import com.user.dto.RegisterDTO;
import com.user.entities.User;

public interface UserService {
	
	public User findByUsername(String username);
	public boolean existsByUsername(String username);
	public void saveUser(RegisterDTO registerDTO);
	public String authenticateUser(LoginDTO loginDTO); 

}
