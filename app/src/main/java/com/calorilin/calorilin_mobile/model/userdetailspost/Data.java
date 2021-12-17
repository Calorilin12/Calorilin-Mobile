package com.calorilin.calorilin_mobile.model.userdetailspost;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("image")
	private String image;

	@SerializedName("tension")
	private String tension;

	@SerializedName("weight")
	private int weight;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_user")
	private int idUser;

	@SerializedName("hyper_tension")
	private int hyperTension;

	@SerializedName("body_mass_index")
	private String bodyMassIndex;

	@SerializedName("stomach_acid")
	private int stomachAcid;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("uric_acid")
	private int uricAcid;

	@SerializedName("cholesterol")
	private int cholesterol;

	@SerializedName("phone_number")
	private String phoneNumber;

	@SerializedName("id")
	private int id;

	@SerializedName("diabetes")
	private int diabetes;

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

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIdUser(int idUser){
		this.idUser = idUser;
	}

	public int getIdUser(){
		return idUser;
	}

	public void setHyperTension(int hyperTension){
		this.hyperTension = hyperTension;
	}

	public int getHyperTension(){
		return hyperTension;
	}

	public void setBodyMassIndex(String bodyMassIndex){
		this.bodyMassIndex = bodyMassIndex;
	}

	public String getBodyMassIndex(){
		return bodyMassIndex;
	}

	public void setStomachAcid(int stomachAcid){
		this.stomachAcid = stomachAcid;
	}

	public int getStomachAcid(){
		return stomachAcid;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUricAcid(int uricAcid){
		this.uricAcid = uricAcid;
	}

	public int getUricAcid(){
		return uricAcid;
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