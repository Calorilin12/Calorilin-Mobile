package com.example.calorilin.model.userpost;

import com.google.gson.annotations.SerializedName;

public class UserEdit{

	@SerializedName("message")
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}