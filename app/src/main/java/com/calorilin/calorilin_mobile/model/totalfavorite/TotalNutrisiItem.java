package com.calorilin.calorilin_mobile.model.totalfavorite;

import com.google.gson.annotations.SerializedName;

public class TotalNutrisiItem{

	@SerializedName("carbo")
	private double carbo;

	@SerializedName("protein")
	private double protein;

	@SerializedName("fat")
	private double fat;

	@SerializedName("calories")
	private double calories;

	public void setCarbo(double carbo){
		this.carbo = carbo;
	}

	public double getCarbo(){
		return carbo;
	}

	public void setProtein(double protein){
		this.protein = protein;
	}

	public double getProtein(){
		return protein;
	}

	public void setFat(double fat){
		this.fat = fat;
	}

	public double getFat(){
		return fat;
	}

	public void setCalories(double calories){
		this.calories = calories;
	}

	public double getCalories(){
		return calories;
	}
}