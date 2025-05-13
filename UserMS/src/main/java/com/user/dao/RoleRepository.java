package com.user.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	public Optional<Role> findByRoleName(String rolename);

}
