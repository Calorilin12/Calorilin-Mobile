package com.calorilin.calorilin_mobile.model.tentangkami;

import com.google.gson.annotations.SerializedName;

public class TentangkamiItem{

	@SerializedName("tentang_kami")
	private String tentangKami;

	@SerializedName("judul")
	private String judul;

	public void setTentangKami(String tentangKami){
		this.tentangKami = tentangKami;
	}

	public String getTentangKami(){
		return tentangKami;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}
}