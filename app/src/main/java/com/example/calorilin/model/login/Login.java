package com.example.calorilin.model.login;

import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("tokens")
	private String tokens;

	@SerializedName("user")
	private User user;

	public void setTokens(String tokens){
		this.tokens = tokens;
	}

	public String getTokens(){
		return tokens;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}