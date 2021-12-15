package com.example.calorilin.model.favorite;

import com.google.gson.annotations.SerializedName;

public class RecipesItem{

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("level_of_difficult")
	private String levelOfDifficult;

	@SerializedName("id")
	private int id;

	@SerializedName("made_by")
	private String madeBy;

	@SerializedName("category")
	private String category;

	@SerializedName("publish_date")
	private String publishDate;
	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
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

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setPublishDate(String publishDate){
		this.publishDate = publishDate;
	}

	public String getPublishDate(){
		return publishDate;
	}
}