package com.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.beans.User;
import com.example.repository.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

   

    
    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser")User user,  Model model){
        System.out.println("in registration controller");
        System.out.println(user.getDateOfBirth());

   
        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }
}
