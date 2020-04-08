package com.example.exceptions;

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

}
