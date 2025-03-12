package com.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.RoleRepository;
import com.user.entities.Role;

@Service
public class RoleServiceImpl implements RoleService{
	
	private RoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Optional<Role> findByRoleName(String rolename) {
		
		return roleRepository.findByRoleName(rolename);
	}


}
