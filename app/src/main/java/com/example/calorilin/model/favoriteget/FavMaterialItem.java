package com.example.calorilin.model.favoriteget;

import com.google.gson.annotations.SerializedName;

public class FavMaterialItem{

	@SerializedName("carbo")
	private int carbo;

	@SerializedName("calory")
	private int calory;

	@SerializedName("time_show")
	private String timeShow;

	@SerializedName("protein")
	private int protein;

	@SerializedName("name")
	private String name;

	@SerializedName("fat")
	private double fat;

	@SerializedName("id")
	private int id;

	@SerializedName("serve")
	private String serve;

	@SerializedName("type")
	private String type;

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

	public void setTimeShow(String timeShow){
		this.timeShow = timeShow;
	}

	public String getTimeShow(){
		return timeShow;
	}

	public void setProtein(int protein){
		this.protein = protein;
	}

	public int getProtein(){
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