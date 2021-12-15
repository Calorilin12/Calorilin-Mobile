package com.calorilin.calorilin_mobile.model.user;

import com.google.gson.annotations.SerializedName;

public class UserData {

	@SerializedName("image")
	private String image;

	@SerializedName("tension")
	private String tension;

	@SerializedName("weight")
	private int weight;

	@SerializedName("check")
	private int check;

	@SerializedName("hyper_tension")
	private int hyperTension;

	@SerializedName("stomach_acid")
	private int stomachAcid;

	@SerializedName("uric_acid")
	private int uricAcid;

	@SerializedName("name")
	private String name;

	@SerializedName("cholesterol")
	private int cholesterol;

	@SerializedName("phone_number")
	private String phoneNumber;

	@SerializedName("id")
	private int id;

	@SerializedName("diabetes")
	private int diabetes;

	@SerializedName("email")
	private String email;

	@SerializedName("born_date")
	private String bornDate;

	@SerializedName("height")
	private int height;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setTension(String tension){
		this.tension = tension;
	}

	public String getTension(){
		return tension;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}

	public void setCheck(int check){
		this.check = check;
	}

	public int getCheck(){
		return check;
	}

	public void setHyperTension(int hyperTension){
		this.hyperTension = hyperTension;
	}

	public int getHyperTension(){
		return hyperTension;
	}

	public void setStomachAcid(int stomachAcid){
		this.stomachAcid = stomachAcid;
	}

	public int getStomachAcid(){
		return stomachAcid;
	}

	public void setUricAcid(int uricAcid){
		this.uricAcid = uricAcid;
	}

	public int getUricAcid(){
		return uricAcid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCholesterol(int cholesterol){
		this.cholesterol = cholesterol;
	}

	public int getCholesterol(){
		return cholesterol;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDiabetes(int diabetes){
		this.diabetes = diabetes;
	}

	public int getDiabetes(){
		return diabetes;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setBornDate(String bornDate){
		this.bornDate = bornDate;
	}

	public String getBornDate(){
		return bornDate;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}
}