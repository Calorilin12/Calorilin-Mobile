package com.example.calorilin.model.register;

import com.google.gson.annotations.SerializedName;

public class Register{

	@SerializedName("user")
	private RegisterUser registerUser;

	@SerializedName("token")
	private String token;

	public void setUser(RegisterUser registerUser){
		this.registerUser = registerUser;
	}

	public RegisterUser getUser(){
		return registerUser;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}
}