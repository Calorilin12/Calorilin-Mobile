package com.example.calorilin.model.disease;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Disease{

	@SerializedName("Disease")
	private List<DiseaseItem> disease;

	public void setDisease(List<DiseaseItem> disease){
		this.disease = disease;
	}

	public List<DiseaseItem> getDisease(){
		return disease;
	}
}