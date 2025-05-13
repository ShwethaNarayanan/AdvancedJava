package com.mongodb.main.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.main.document.Student;

@Repository
public interface StudentDAO extends MongoRepository<Student, Integer>{

}
