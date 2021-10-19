package com.example.calorilin.model.login;

import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("user")
	private LoginUser loginUser;

	@SerializedName("token")
	private String token;

	public void setUser(LoginUser loginUser){
		this.loginUser = loginUser;
	}

	public LoginUser getUser(){
		return loginUser;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}
}