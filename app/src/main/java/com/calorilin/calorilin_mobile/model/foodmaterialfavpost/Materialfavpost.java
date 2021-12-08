package com.calorilin.calorilin_mobile.model.foodmaterialfavpost;

import com.google.gson.annotations.SerializedName;

public class Materialfavpost{

	@SerializedName("message")
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}