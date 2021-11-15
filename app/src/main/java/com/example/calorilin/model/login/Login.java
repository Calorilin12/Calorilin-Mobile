package com.example.calorilin.model.login;

public class Login{

	private String token;
	private User user;

	public void setTokens(String tokens){
		this.token = tokens;
	}

	public String getTokens(){
		return token;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}