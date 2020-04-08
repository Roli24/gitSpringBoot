package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.beans.Login;
import com.example.beans.User;

@ControllerAdvice
public class DefaultModelAttributeController {
	
	
	  @ModelAttribute("newuser")
	    public User getDefaultUser()
	    {
	    	return new User();
	    }
	    
	    @ModelAttribute("genderItems")
	    public List<String> getGenderItems()
	    {
	    	return Arrays.asList(new String[] {"Male", "Female", "Other"});
	    }
	    
	    
	    @ModelAttribute("login")
	    public Login getDefaultLogin()
	    {
	    	return new Login();
	    }

}
