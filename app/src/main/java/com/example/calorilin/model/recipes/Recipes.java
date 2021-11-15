package com.example.calorilin.model.recipes;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Recipes{

	@SerializedName("recipes")
	private List<RecipesItem> recipes;

	public void setRecipes(List<RecipesItem> recipes){
		this.recipes = recipes;
	}

	public List<RecipesItem> getRecipes(){
		return recipes;
	}
}