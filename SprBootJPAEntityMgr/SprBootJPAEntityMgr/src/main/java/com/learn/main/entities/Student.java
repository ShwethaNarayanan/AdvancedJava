package com.learn.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "studentdb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private int age;
	@Column
	private String email;
	@Column
	private String gender;

}
