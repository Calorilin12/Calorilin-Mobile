package com.calorilin.calorilin_mobile.model.foodmaterial;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FoodMaterial{

	@SerializedName("FoodMaterial")
	private List<FoodMaterialItem> foodMaterial;

	public void setFoodMaterial(List<FoodMaterialItem> foodMaterial){
		this.foodMaterial = foodMaterial;
	}

	public List<FoodMaterialItem> getFoodMaterial(){
		return foodMaterial;
	}
}