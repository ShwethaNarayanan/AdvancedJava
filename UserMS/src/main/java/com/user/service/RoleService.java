package com.user.service;

import java.util.Optional;

import com.user.entities.Role;

public interface RoleService {

	public Optional<Role> findByRoleName(String rolename);
}
