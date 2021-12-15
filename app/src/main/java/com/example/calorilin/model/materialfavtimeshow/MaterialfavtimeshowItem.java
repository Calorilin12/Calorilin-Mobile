package com.example.calorilin.model.materialfavtimeshow;

import com.google.gson.annotations.SerializedName;

public class MaterialfavtimeshowItem{

	@SerializedName("id_food_material")
	private int idFoodMaterial;

	@SerializedName("time_show")
	private String timeShow;

	@SerializedName("image")
	private String image;

	@SerializedName("carbo")
	private double carbo;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_user")
	private int idUser;

	@SerializedName("serve")
	private String serve;

	@SerializedName("type")
	private String type;

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

	@SerializedName("id")
	private int id;

	public void setIdFoodMaterial(int idFoodMaterial){
		this.idFoodMaterial = idFoodMaterial;
	}

	public int getIdFoodMaterial(){
		return idFoodMaterial;
	}

	public void setTimeShow(String timeShow){
		this.timeShow = timeShow;
	}

	public String getTimeShow(){
		return timeShow;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCarbo(double carbo){
		this.carbo = carbo;
	}

	public double getCarbo(){
		return carbo;
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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}