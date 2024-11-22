package com.learn.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.learn.main.entities.Students;
import com.learn.main.service.StudentService;
import com.learn.main.service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootJpaApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJpaApplication.class, args);
		StudentService stdService = context.getBean(StudentServiceImpl.class);
		
		
		// ----------------------- Insert ---------------------------------------------------
		Students std = new Students();
		std.setName("Soni");
		std.setRollno(19);
		std.setMarks(85F);
		boolean status;
		status = stdService.saveStudent(std);
		if(status == true)
			System.out.println("Student data inserted successfully!");
		else
			System.out.println("Data insertion failed!");
		
		
		// ----------------------- SELECT by ID ---------------------------------------------------
		Students std1 = stdService.find(2);
		
		System.out.println(std1);
		
		// ----------------------- SELECT All---------------------------------------------------
				List<Students> std_list = stdService.findAll();
				for(Students student  : std_list) {
						System.out.println(student);
				}
				
		// -----------------------Update ------------------------------------------------------
				
				status = stdService.updateStudent(1, 90F);
				if(status == true)
					System.out.println("Student data updated successfully!");
				else
					System.out.println("Data update failed!");	
				
	  //----------------------------- Delete by ID ---------------------------------------------
				
				status = stdService.deleteStudent(3);
				if(status == true)
					System.out.println("Student data deleted successfully!");
				else
					System.out.println("Deletion failed!");
	}

}
