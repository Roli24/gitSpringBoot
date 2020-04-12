package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {
	
	@GetMapping("redirectToLinkedin")
	public String redirect()
	{
		return "redirect:http://www.linkedin.com";
	}

}
