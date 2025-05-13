package com.mongodb.main.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Student {
	
	@Id
	private int studentid;
	private String fname;
	private String lname;
	private int age;

}
