package com.example.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.beans.Login;
import com.example.beans.User;
import com.example.exceptions.ApplicationException;
import com.example.repository.UserRepository;

@Controller
@SessionAttributes("login")
public class LoginController {
	@Autowired
	private UserRepository userRepository;
	
	

	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login, HttpSession session) {
		User user = userRepository.searchByName(login.getUsername());
//		/session.setAttribute(arg0, arg1);
		if (user == null)
			throw new ApplicationException("User not found");
		return "forward:/userprofile";
	}

	@ExceptionHandler(ApplicationException.class)
	public String handleException() {
		System.out.println("In Exception Handler of Login Controller");
		return "error";
	}

}
