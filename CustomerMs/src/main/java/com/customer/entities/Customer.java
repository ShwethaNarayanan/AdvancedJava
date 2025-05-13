package com.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String firstname;
	private String lastname;
	private String middlename;
	private String email;
	private String username;
//	@Embedded
//	private Address address;
     
	//Created for JPA 
	protected Customer() {		
	}
	
	private Customer(CustomerBuilder customerBuilder) {
		this.firstname = customerBuilder.firstname;
		this.lastname = customerBuilder.lastname;
		this.email = customerBuilder.email;
		this.middlename = customerBuilder.middlename;
		this.username = customerBuilder.username;
		// this.address = address;
	}

	

	public String getUsername() {
		return username;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getEmail() {
		return email;
	}

	

	public static class CustomerBuilder {

		private String firstname;
		private String lastname;
		private String email;
		private String middlename;
		private String username;
//		private Address address;

		// Public constructor for the mandatory fields
		public CustomerBuilder(String firstname, String lastname, String email, String username) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.username = username;
		}

		public CustomerBuilder setMiddlename(String middlename) {
			this.middlename = middlename;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}

}
