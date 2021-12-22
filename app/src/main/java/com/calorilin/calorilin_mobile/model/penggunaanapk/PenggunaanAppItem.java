package com.calorilin.calorilin_mobile.model.penggunaanapk;

import com.google.gson.annotations.SerializedName;

public class PenggunaanAppItem{

	@SerializedName("judul")
	private String judul;

	@SerializedName("penggunaan_aplikasi")
	private String penggunaanAplikasi;

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setPenggunaanAplikasi(String penggunaanAplikasi){
		this.penggunaanAplikasi = penggunaanAplikasi;
	}

	public String getPenggunaanAplikasi(){
		return penggunaanAplikasi;
	}
}