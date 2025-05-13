package com.user.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.dao.UserRepository;
import com.user.dto.LoginDTO;
import com.user.dto.RegisterDTO;
import com.user.entities.Role;
import com.user.entities.User;
import com.user.exceptions.CustomExceptions;
import com.user.utils.JWTService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private RoleService roleService;
	private AuthenticationManager authenticationManager;
	private JWTService jwtService;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService,
			AuthenticationManager authenticationManager, JWTService jwtService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.roleService = roleService;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@Override
	public User findByUsername(String username) {
		
		User user = userRepository.findByUsername(username).orElse(null);
		return user;
	}

	@Override
	public boolean existsByUsername(String username) {
		
		return userRepository.existsByUsername(username);
	}

	@Override
	public void saveUser(RegisterDTO registerDTO) {
		
		User user = new User();
		user.setUsername(registerDTO.getUsername());
		user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
		Role role = roleService.findByRoleName("USER").get();
		user.setRoles(Collections.singletonList(role));
		userRepository.save(user);
		
	}

	@Override
	public String authenticateUser(LoginDTO loginDTO) {
		// Attempts to authenticate the passed Authentication object, returning a fully populated 
		// Authentication object (including granted authorities)if successful. 
		// UsernamePasswordAuthenticationToken constructor can be used to create a UsernamePasswordAuthenticationToken.
		Authentication authenticatonToken = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
																loginDTO.getPassword()));
		
		if(!authenticatonToken.isAuthenticated()) {
			throw new CustomExceptions(HttpStatus.FORBIDDEN, "Authentication failed!");
		}
		
		SecurityContextHolder.getContext().setAuthentication(authenticatonToken);
		return jwtService.generateToken(authenticatonToken);
	}

}
