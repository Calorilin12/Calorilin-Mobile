package com.calorilin.calorilin_mobile.model.foodmaterial;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class FoodMaterialItem implements Parcelable {

	@SerializedName("image")
	private String image;

	@SerializedName("carbo")
	private double carbo;

	@SerializedName("calory")
	private int calory;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("protein")
	private double protein;

	@SerializedName("name")
	private String name;

	@SerializedName("fat")
	private double fat;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("serve")
	private String serve;

	@SerializedName("type")
	private String type;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCarbo(double carbo){
		this.carbo = carbo;
	}

	public double getCarbo(){
		return carbo;
	}

	public void setCalory(int calory){
		this.calory = calory;
	}

	public int getCalory(){
		return calory;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setProtein(double protein){
		this.protein = protein;
	}

	public double getProtein(){
		return protein;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setFat(double fat){
		this.fat = fat;
	}

	public double getFat(){
		return fat;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setServe(String serve){
		this.serve = serve;
	}

	public String getServe(){
		return serve;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.image);
		dest.writeDouble(this.carbo);
		dest.writeInt(this.calory);
		dest.writeString(this.updatedAt);
		dest.writeDouble(this.protein);
		dest.writeString(this.name);
		dest.writeDouble(this.fat);
		dest.writeString(this.createdAt);
		dest.writeInt(this.id);
		dest.writeString(this.serve);
		dest.writeString(this.type);
	}

	public void readFromParcel(Parcel source) {
		this.image = source.readString();
		this.carbo = source.readDouble();
		this.calory = source.readInt();
		this.updatedAt = source.readString();
		this.protein = source.readDouble();
		this.name = source.readString();
		this.fat = source.readDouble();
		this.createdAt = source.readString();
		this.id = source.readInt();
		this.serve = source.readString();
		this.type = source.readString();
	}

	public FoodMaterialItem() {
	}

	protected FoodMaterialItem(Parcel in) {
		this.image = in.readString();
		this.carbo = in.readDouble();
		this.calory = in.readInt();
		this.updatedAt = in.readString();
		this.protein = in.readDouble();
		this.name = in.readString();
		this.fat = in.readDouble();
		this.createdAt = in.readString();
		this.id = in.readInt();
		this.serve = in.readString();
		this.type = in.readString();
	}

	public static final Parcelable.Creator<FoodMaterialItem> CREATOR = new Parcelable.Creator<FoodMaterialItem>() {
		@Override
		public FoodMaterialItem createFromParcel(Parcel source) {
			return new FoodMaterialItem(source);
		}

		@Override
		public FoodMaterialItem[] newArray(int size) {
			return new FoodMaterialItem[size];
		}
	};
}