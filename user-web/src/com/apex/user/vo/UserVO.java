package com.apex.user.vo;

public class UserVO {
	//private int id;
	private String  firstName;
	private String	lastName;
	private String  middleName;
	public UserVO() {
		super();
	}
	/**
	 * This is argument constructor
	 * @param id - id of person
	 * @param firstName - first name of person
	 * @param lastName - last name of person
	 * @param middleName - middle name
	 */
	public UserVO(String firstName, String lastName, String middleName) {
		//this.id = id;
		//this logic take care
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}
//	public int getId() {
//		return id;
//	}
//	public void setFirstName(int id) {
//		this.id = id;
//	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
}
