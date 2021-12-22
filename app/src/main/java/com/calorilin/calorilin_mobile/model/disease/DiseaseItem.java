package com.calorilin.calorilin_mobile.model.disease;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DiseaseItem implements Parcelable {

	@SerializedName("total_calory")
	private int totalCalory;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("steps_of_make")
	private String stepsOfMake;

	@SerializedName("compositions")
	private String compositions;

	@SerializedName("hyper_tension")
	private int hyperTension;

	@SerializedName("total_eater")
	private int totalEater;

	@SerializedName("id_recipe")
	private int idRecipe;

	@SerializedName("duration")
	private int duration;

	@SerializedName("stomach_acid")
	private int stomachAcid;

	@SerializedName("updated_at")
	private String updatedAt;


	@SerializedName("short_description")
	private String shortDescription;

	@SerializedName("recipe_image")
	private String recipeImage;

	@SerializedName("uric_acid")
	private int uricAcid;

	@SerializedName("name")
	private String name;

	@SerializedName("cholesterol")
	private int cholesterol;

	@SerializedName("level_of_difficult")
	private String levelOfDifficult;

	@SerializedName("id")
	private int id;

	@SerializedName("made_by")
	private String madeBy;

	@SerializedName("publish_date")
	private String publishDate;

	@SerializedName("diabetes")
	private int diabetes;

	public void setTotalCalory(int totalCalory){
		this.totalCalory = totalCalory;
	}

	public int getTotalCalory(){
		return totalCalory;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setStepsOfMake(String stepsOfMake){
		this.stepsOfMake = stepsOfMake;
	}

	public String getStepsOfMake(){
		return stepsOfMake;
	}

	public void setCompositions(String compositions){
		this.compositions = compositions;
	}

	public String getCompositions(){
		return compositions;
	}

	public void setHyperTension(int hyperTension){
		this.hyperTension = hyperTension;
	}

	public int getHyperTension(){
		return hyperTension;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setTotalEater(int totalEater){
		this.totalEater = totalEater;
	}

	public int getTotalEater(){
		return totalEater;
	}

	public void setIdRecipe(int idRecipe){
		this.idRecipe = idRecipe;
	}

	public int getIdRecipe(){
		return idRecipe;
	}

	public void setDuration(int duration){
		this.duration = duration;
	}

	public int getDuration(){
		return duration;
	}

	public void setStomachAcid(int stomachAcid){
		this.stomachAcid = stomachAcid;
	}

	public int getStomachAcid(){
		return stomachAcid;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setRecipeImage(String recipeImage){
		this.recipeImage = recipeImage;
	}

	public String getRecipeImage(){
		return recipeImage;
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

	public void setLevelOfDifficult(String levelOfDifficult){
		this.levelOfDifficult = levelOfDifficult;
	}

	public String getLevelOfDifficult(){
		return levelOfDifficult;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMadeBy(String madeBy){
		this.madeBy = madeBy;
	}

	public String getMadeBy(){
		return madeBy;
	}

	public void setPublishDate(String publishDate){
		this.publishDate = publishDate;
	}

	public String getPublishDate(){
		return publishDate;
	}

	public void setDiabetes(int diabetes){
		this.diabetes = diabetes;
	}

	public int getDiabetes(){
		return diabetes;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.totalCalory);
		dest.writeString(this.createdAt);
		dest.writeString(this.stepsOfMake);
		dest.writeString(this.compositions);
		dest.writeInt(this.hyperTension);
		dest.writeInt(this.totalEater);
		dest.writeInt(this.idRecipe);
		dest.writeInt(this.duration);
		dest.writeInt(this.stomachAcid);
		dest.writeString(this.updatedAt);
		dest.writeString(this.recipeImage);
		dest.writeInt(this.uricAcid);
		dest.writeString(this.name);
		dest.writeInt(this.cholesterol);
		dest.writeString(this.levelOfDifficult);
		dest.writeInt(this.id);
		dest.writeString(this.madeBy);
		dest.writeString(this.publishDate);
		dest.writeInt(this.diabetes);
	}

	public void readFromParcel(Parcel source) {
		this.totalCalory = source.readInt();
		this.createdAt = source.readString();
		this.stepsOfMake = source.readString();
		this.compositions = source.readString();
		this.hyperTension = source.readInt();
		this.totalEater = source.readInt();
		this.idRecipe = source.readInt();
		this.duration = source.readInt();
		this.stomachAcid = source.readInt();
		this.updatedAt = source.readString();
		this.recipeImage = source.readString();
		this.uricAcid = source.readInt();
		this.name = source.readString();
		this.cholesterol = source.readInt();
		this.levelOfDifficult = source.readString();
		this.id = source.readInt();
		this.madeBy = source.readString();
		this.publishDate = source.readString();
		this.diabetes = source.readInt();
	}

	public DiseaseItem() {
	}

	protected DiseaseItem(Parcel in) {
		this.totalCalory = in.readInt();
		this.createdAt = in.readString();
		this.stepsOfMake = in.readString();
		this.compositions = in.readString();
		this.hyperTension = in.readInt();
		this.totalEater = in.readInt();
		this.idRecipe = in.readInt();
		this.duration = in.readInt();
		this.stomachAcid = in.readInt();
		this.updatedAt = in.readString();
		this.recipeImage = in.readString();
		this.uricAcid = in.readInt();
		this.name = in.readString();
		this.cholesterol = in.readInt();
		this.levelOfDifficult = in.readString();
		this.id = in.readInt();
		this.madeBy = in.readString();
		this.publishDate = in.readString();
		this.diabetes = in.readInt();
	}

	public static final Parcelable.Creator<DiseaseItem> CREATOR = new Parcelable.Creator<DiseaseItem>() {
		@Override
		public DiseaseItem createFromParcel(Parcel source) {
			return new DiseaseItem(source);
		}

		@Override
		public DiseaseItem[] newArray(int size) {
			return new DiseaseItem[size];
		}
	};
}