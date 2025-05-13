package com.profiles.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profiles.main.entities.Student;

public interface StudentJPADAO extends JpaRepository<Student, Integer>{

}
