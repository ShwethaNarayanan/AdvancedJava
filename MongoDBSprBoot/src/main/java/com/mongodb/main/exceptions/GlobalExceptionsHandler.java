package com.mongodb.main.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {
	
	@ExceptionHandler(CustomExceptions.class)
	public ResponseEntity<String> handleCustomExceptions(CustomExceptions ex){
		return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
	}

}
