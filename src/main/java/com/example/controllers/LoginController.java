package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.beans.Login;
import com.example.beans.User;
import com.example.exceptions.ApplicationException;
import com.example.repository.UserRepository;
@Controller
public class LoginController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login)
	{
		User user = userRepository.searchByName(login.getUsername());
		if(user == null)
			throw new ApplicationException("User not found");
		return "search";
	}
	
	
	 @ExceptionHandler(ApplicationException.class) public String handleException()
	  { System.out.println("In Exception Handler of Login Controller"); return
	 "error"; }
	
	

}
