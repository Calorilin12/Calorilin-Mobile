package com.example.calorilin.model.user;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

	@SerializedName("image")
	private String image;

	@SerializedName("tension")
	private String tension;

	@SerializedName("weight")
	private int weight;

	@SerializedName("check")
	private int check;

	@SerializedName("hyper_tension")
	private int hyperTension;

	@SerializedName("stomach_acid")
	private int stomachAcid;

	@SerializedName("uric_acid")
	private int uricAcid;

	@SerializedName("name")
	private String name;

	@SerializedName("cholesterol")
	private int cholesterol;

	@SerializedName("phone_number")
	private String phoneNumber;

	@SerializedName("id")
	private int id;

	@SerializedName("diabetes")
	private int diabetes;

	@SerializedName("email")
	private String email;

	@SerializedName("born_date")
	private String bornDate;

	@SerializedName("height")
	private int height;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setTension(String tension){
		this.tension = tension;
	}

	public String getTension(){
		return tension;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}

	public void setCheck(int check){
		this.check = check;
	}

	public int getCheck(){
		return check;
	}

	public void setHyperTension(int hyperTension){
		this.hyperTension = hyperTension;
	}

	public int getHyperTension(){
		return hyperTension;
	}

	public void setStomachAcid(int stomachAcid){
		this.stomachAcid = stomachAcid;
	}

	public int getStomachAcid(){
		return stomachAcid;
	}

	public void setUricAcid(int uricAcid){
		this.uricAcid = uricAcid;
	}

	public int getUricAcid(){
		return uricAcid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCholesterol(int cholesterol){
		this.cholesterol = cholesterol;
	}

	public int getCholesterol(){
		return cholesterol;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDiabetes(int diabetes){
		this.diabetes = diabetes;
	}

	public int getDiabetes(){
		return diabetes;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setBornDate(String bornDate){
		this.bornDate = bornDate;
	}

	public String getBornDate(){
		return bornDate;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.image);
		dest.writeString(this.tension);
		dest.writeInt(this.weight);
		dest.writeInt(this.check);
		dest.writeInt(this.hyperTension);
		dest.writeInt(this.stomachAcid);
		dest.writeInt(this.uricAcid);
		dest.writeString(this.name);
		dest.writeInt(this.cholesterol);
		dest.writeString(this.phoneNumber);
		dest.writeInt(this.id);
		dest.writeInt(this.diabetes);
		dest.writeString(this.email);
		dest.writeString(this.bornDate);
		dest.writeInt(this.height);
	}

	public void readFromParcel(Parcel source) {
		this.image = source.readString();
		this.tension = source.readString();
		this.weight = source.readInt();
		this.check = source.readInt();
		this.hyperTension = source.readInt();
		this.stomachAcid = source.readInt();
		this.uricAcid = source.readInt();
		this.name = source.readString();
		this.cholesterol = source.readInt();
		this.phoneNumber = source.readString();
		this.id = source.readInt();
		this.diabetes = source.readInt();
		this.email = source.readString();
		this.bornDate = source.readString();
		this.height = source.readInt();
	}

	public User() {
	}

	protected User(Parcel in) {
		this.image = in.readString();
		this.tension = in.readString();
		this.weight = in.readInt();
		this.check = in.readInt();
		this.hyperTension = in.readInt();
		this.stomachAcid = in.readInt();
		this.uricAcid = in.readInt();
		this.name = in.readString();
		this.cholesterol = in.readInt();
		this.phoneNumber = in.readString();
		this.id = in.readInt();
		this.diabetes = in.readInt();
		this.email = in.readString();
		this.bornDate = in.readString();
		this.height = in.readInt();
	}

	public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
		@Override
		public User createFromParcel(Parcel source) {
			return new User(source);
		}

		@Override
		public User[] newArray(int size) {
			return new User[size];
		}
	};
}