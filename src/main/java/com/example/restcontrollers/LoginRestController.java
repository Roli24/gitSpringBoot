package com.example.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Login;
import com.example.beans.User;
import com.example.exceptions.LoginFailureException;
import com.example.repository.UserRepository;

@RestController
public class LoginRestController {

	@Autowired
	private UserRepository UserRepository;

	@PostMapping("/hplus/rest/loginUser")
	public ResponseEntity loginUser(@RequestBody Login login) throws LoginFailureException{
		System.out.println(login.getUsername() + " " + login.getPassword());
		User user = UserRepository.searchByName(login.getUsername());

		if (user == null) {
			return ResponseEntity.status(400).build();
		}

		if (user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())) {
			return new ResponseEntity<>(HttpStatus.OK);

		}else {
			throw new LoginFailureException("Invalid username or password");
			
		}

	}

}
