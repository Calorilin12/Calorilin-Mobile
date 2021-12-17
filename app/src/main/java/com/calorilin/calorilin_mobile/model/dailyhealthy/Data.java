package com.calorilin.calorilin_mobile.model.dailyhealthy;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("push_up")
	private int pushUp;

	@SerializedName("sit_up")
	private int sitUp;

	@SerializedName("drinks")
	private int drinks;

	@SerializedName("weight")
	private int weight;

	@SerializedName("run")
	private int run;

	@SerializedName("id")
	private int id;

	@SerializedName("height")
	private int height;

	@SerializedName("body_mass_index")
	private String bodyMassIndex;

	public void setPushUp(int pushUp){
		this.pushUp = pushUp;
	}

	public int getPushUp(){
		return pushUp;
	}

	public void setSitUp(int sitUp){
		this.sitUp = sitUp;
	}

	public int getSitUp(){
		return sitUp;
	}

	public void setDrinks(int drinks){
		this.drinks = drinks;
	}

	public int getDrinks(){
		return drinks;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}

	public void setRun(int run){
		this.run = run;
	}

	public int getRun(){
		return run;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setBodyMassIndex(String bodyMassIndex){
		this.bodyMassIndex = bodyMassIndex;
	}

	public String getBodyMassIndex(){
		return bodyMassIndex;
	}
}