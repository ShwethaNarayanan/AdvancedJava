package com.learn.main.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.main.entities.Students;

public interface StudentRepository extends JpaRepository<Students, Integer>{
 
	  
}
