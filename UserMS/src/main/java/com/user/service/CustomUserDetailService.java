package com.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.dao.UserRepository;
import com.user.entities.Role;
import com.user.entities.User;

@Service
public class CustomUserDetailService implements UserDetailsService {

	private UserRepository userRepository;
	
	@Autowired
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		//Spring security's User class implements UserDetails interface. So use that instead of creating custom UserDetails
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToGrantedAuthority(user.getRoles()));
	}
	
	// Method to map Roles to GrantedAuthority
	public List<GrantedAuthority> mapRolesToGrantedAuthority(List<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

}
