package com.imarticus.tutorial.controllers;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imarticus.tutorial.dtos.TokenResponse;
import com.imarticus.tutorial.dtos.User;
import com.imarticus.tutorial.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User registerUser(@RequestBody User login) throws ServletException{
		
		if (login.getUsername() == null || login.getPassword() == null) {
			throw new ServletException("username and password mandatory for register");
		}
		
		return userService.addUser(login);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public TokenResponse login(@RequestBody User login) throws ServletException {

		String jwtToken = "";

		if (login.getUsername() == null || login.getPassword() == null) {
			throw new ServletException("username and password mandatory for login");
		}

		String username = login.getUsername();
		String password = login.getPassword();

		User user = userService.findByUserName(username);

		if (user == null) {
			throw new ServletException("username not found.");
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your username and password.");
		}
		
		

		jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		
		TokenResponse token = new TokenResponse(username,"Success",jwtToken);
		return token;
	}
}


