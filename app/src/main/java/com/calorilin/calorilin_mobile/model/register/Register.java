package com.calorilin.calorilin_mobile.model.register;

import com.google.gson.annotations.SerializedName;

public class Register{

	@SerializedName("user")
	private User user;

	@SerializedName("token")
	private String token;

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}
}