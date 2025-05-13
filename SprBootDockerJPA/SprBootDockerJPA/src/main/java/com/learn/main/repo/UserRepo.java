package com.learn.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.main.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
