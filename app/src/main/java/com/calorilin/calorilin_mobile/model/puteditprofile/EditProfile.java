package com.calorilin.calorilin_mobile.model.puteditprofile;

import com.google.gson.annotations.SerializedName;

public class EditProfile{

	@SerializedName("message")
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}