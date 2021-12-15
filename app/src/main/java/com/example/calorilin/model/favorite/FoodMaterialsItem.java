package com.example.calorilin.model.favorite;

import com.google.gson.annotations.SerializedName;

public class FoodMaterialsItem{

	@SerializedName("image")
	private String image;

	@SerializedName("carbo")
	private int carbo;

	@SerializedName("calory")
	private int calory;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("protein")
	private double protein;

	@SerializedName("name")
	private String name;

	@SerializedName("fat")
	private double fat;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("serve")
	private String serve;

	@SerializedName("type")
	private String type;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCarbo(int carbo){
		this.carbo = carbo;
	}

	public int getCarbo(){
		return carbo;
	}

	public void setCalory(int calory){
		this.calory = calory;
	}

	public int getCalory(){
		return calory;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setProtein(double protein){
		this.protein = protein;
	}

	public double getProtein(){
		return protein;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setFat(double fat){
		this.fat = fat;
	}

	public double getFat(){
		return fat;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setServe(String serve){
		this.serve = serve;
	}

	public String getServe(){
		return serve;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}