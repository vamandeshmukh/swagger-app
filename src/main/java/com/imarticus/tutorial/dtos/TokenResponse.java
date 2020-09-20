package com.imarticus.tutorial.dtos;

public class TokenResponse {

	public String username;
	public String message;
	public String token;
	public TokenResponse(String username, String message, String token) {
		super();
		this.username = username;
		this.message = message;
		this.token = token;
	}
	
}
