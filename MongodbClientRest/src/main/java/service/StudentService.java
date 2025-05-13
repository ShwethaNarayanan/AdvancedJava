package service;

import com.mongodb.client.MongoClient;

import document.Student;

public interface StudentService {
	
	public MongoClient getConnection();
	
	public void saveStudent(Student student);
	
	public Student getStudentById(int id);
	
	public void updateStudent(int id, String lname, int age);
	
	public void deleteStudent(int id);

}
