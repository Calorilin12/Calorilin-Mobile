package com.calorilin.calorilin_mobile.model.reportbug;

import com.google.gson.annotations.SerializedName;

public class ReportBug{

	@SerializedName("message")
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}