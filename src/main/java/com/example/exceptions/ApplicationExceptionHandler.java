package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(ApplicationException.class)
	public String handleException()
	{
		System.out.println("In global Exception Handler of Login Controller");
		return "error";
	}
	
	
	@ExceptionHandler(LoginFailureException.class)
	public ResponseEntity  handleLoginFailure(LoginFailureException exLoginFailureException)
	{
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exLoginFailureException.getMessage());
	}
	

}
