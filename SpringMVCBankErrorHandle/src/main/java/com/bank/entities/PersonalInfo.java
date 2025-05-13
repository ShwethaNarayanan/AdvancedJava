package com.bank.entities;

import org.hibernate.validator.constraints.NotEmpty;

public class PersonalInfo {
	
	@NotEmpty(message = "First name cannot be left blank")
	private String fname;
	@NotEmpty(message = "Last name cannot be left blank")
	private String lname;
	private String mname;
	@NotEmpty(message = "Select a gender")
	private String gender;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public PersonalInfo(String fname,
			String lname, String mname,
			String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mname = mname;
		this.gender = gender;
	}
	public PersonalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
