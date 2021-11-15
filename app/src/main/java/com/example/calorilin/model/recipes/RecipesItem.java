package com.example.calorilin.model.recipes;

import com.google.gson.annotations.SerializedName;

public class RecipesItem{

	@SerializedName("total_calory")
	private int totalCalory;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("steps_of_make")
	private String stepsOfMake;

	@SerializedName("compositions")
	private String compositions;

	@SerializedName("hyper_tension")
	private int hyperTension;

	@SerializedName("total_eater")
	private int totalEater;

	@SerializedName("id_recipe")
	private int idRecipe;

	@SerializedName("duration")
	private int duration;

	@SerializedName("stomach_acid")
	private int stomachAcid;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("recipe_image")
	private String recipeImage;

	@SerializedName("uric_acid")
	private int uricAcid;

	@SerializedName("name")
	private String name;

	@SerializedName("cholesterol")
	private int cholesterol;

	@SerializedName("level_of_difficult")
	private String levelOfDifficult;

	@SerializedName("id")
	private int id;

	@SerializedName("made_by")
	private String madeBy;

	@SerializedName("publish_date")
	private String publishDate;

	@SerializedName("diabetes")
	private int diabetes;

	public void setTotalCalory(int totalCalory){
		this.totalCalory = totalCalory;
	}

	public int getTotalCalory(){
		return totalCalory;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setStepsOfMake(String stepsOfMake){
		this.stepsOfMake = stepsOfMake;
	}

	public String getStepsOfMake(){
		return stepsOfMake;
	}

	public void setCompositions(String compositions){
		this.compositions = compositions;
	}

	public String getCompositions(){
		return compositions;
	}

	public void setHyperTension(int hyperTension){
		this.hyperTension = hyperTension;
	}

	public int getHyperTension(){
		return hyperTension;
	}

	public void setTotalEater(int totalEater){
		this.totalEater = totalEater;
	}

	public int getTotalEater(){
		return totalEater;
	}

	public void setIdRecipe(int idRecipe){
		this.idRecipe = idRecipe;
	}

	public int getIdRecipe(){
		return idRecipe;
	}

	public void setDuration(int duration){
		this.duration = duration;
	}

	public int getDuration(){
		return duration;
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

	public void setRecipeImage(String recipeImage){
		this.recipeImage = recipeImage;
	}

	public String getRecipeImage(){
		return recipeImage;
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

	public void setLevelOfDifficult(String levelOfDifficult){
		this.levelOfDifficult = levelOfDifficult;
	}

	public String getLevelOfDifficult(){
		return levelOfDifficult;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMadeBy(String madeBy){
		this.madeBy = madeBy;
	}

	public String getMadeBy(){
		return madeBy;
	}

	public void setPublishDate(String publishDate){
		this.publishDate = publishDate;
	}

	public String getPublishDate(){
		return publishDate;
	}

	public void setDiabetes(int diabetes){
		this.diabetes = diabetes;
	}

	public int getDiabetes(){
		return diabetes;
	}
}