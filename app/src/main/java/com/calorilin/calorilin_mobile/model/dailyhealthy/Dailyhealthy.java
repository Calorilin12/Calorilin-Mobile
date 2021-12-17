package com.calorilin.calorilin_mobile.model.dailyhealthy;

import com.google.gson.annotations.SerializedName;

public class Dailyhealthy{

	@SerializedName("data")
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}
}