package service;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import document.Student;

public class StudentServiceImpl implements StudentService {

	
	@Override
	public void saveStudent(Student student) {
		MongoClient mongoClient = getConnection();
		MongoDatabase database = mongoClient.getDatabase("mongodbspring");
		MongoCollection<Document> studentCollection = database.getCollection("student");

		studentCollection.insertOne(new Document()
		  .append("_id", new ObjectId())
		  .append("fname", student.getFname())
		  .append("lname", student.getLname())
		  .append("age", student.getAge()));
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(int id, String lname, int age) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public MongoClient getConnection() {
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/");
		return mongoClient;
	}

}
