package com.bank.exceptions;

import org.springframework.http.HttpStatus;

public class CustomExceptions extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;
	
	
	public CustomExceptions() {
	}
	
	public CustomExceptions(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}
