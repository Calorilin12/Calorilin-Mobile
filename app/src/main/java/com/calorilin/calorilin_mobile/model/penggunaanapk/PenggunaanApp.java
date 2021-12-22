package com.calorilin.calorilin_mobile.model.penggunaanapk;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PenggunaanApp{

	@SerializedName("PenggunaanApp")
	private List<PenggunaanAppItem> penggunaanApp;

	public void setPenggunaanApp(List<PenggunaanAppItem> penggunaanApp){
		this.penggunaanApp = penggunaanApp;
	}

	public List<PenggunaanAppItem> getPenggunaanApp(){
		return penggunaanApp;
	}
}