package com.example.calorilin.model.favoriteget;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FavMaterial{

	@SerializedName("FavMaterial")
	private List<FavMaterialItem> favMaterial;

	public void setFavMaterial(List<FavMaterialItem> favMaterial){
		this.favMaterial = favMaterial;
	}

	public List<FavMaterialItem> getFavMaterial(){
		return favMaterial;
	}
}