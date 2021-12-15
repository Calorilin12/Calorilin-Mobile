package com.example.calorilin.model.favorite;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FavoriteSearch{

	@SerializedName("recipes")
	private List<RecipesItem> recipes;

	@SerializedName("food_materials")
	private List<FoodMaterialsItem> foodMaterials;

	public void setRecipes(List<RecipesItem> recipes){
		this.recipes = recipes;
	}

	public List<RecipesItem> getRecipes(){
		return recipes;
	}

	public void setFoodMaterials(List<FoodMaterialsItem> foodMaterials){
		this.foodMaterials = foodMaterials;
	}

	public List<FoodMaterialsItem> getFoodMaterials(){
		return foodMaterials;
	}
}