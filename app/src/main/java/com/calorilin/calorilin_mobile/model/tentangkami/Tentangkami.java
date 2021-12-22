package com.calorilin.calorilin_mobile.model.tentangkami;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Tentangkami{

	@SerializedName("Tentangkami")
	private List<TentangkamiItem> tentangkami;

	public void setTentangkami(List<TentangkamiItem> tentangkami){
		this.tentangkami = tentangkami;
	}

	public List<TentangkamiItem> getTentangkami(){
		return tentangkami;
	}
}