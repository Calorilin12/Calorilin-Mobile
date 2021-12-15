package com.calorilin.calorilin_mobile.model.materialfavtimeshow;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Materialfavtimeshow{

	@SerializedName("materialfavtimeshow")
	private List<MaterialfavtimeshowItem> materialfavtimeshow;

	public void setMaterialfavtimeshow(List<MaterialfavtimeshowItem> materialfavtimeshow){
		this.materialfavtimeshow = materialfavtimeshow;
	}

	public List<MaterialfavtimeshowItem> getMaterialfavtimeshow(){
		return materialfavtimeshow;
	}
}