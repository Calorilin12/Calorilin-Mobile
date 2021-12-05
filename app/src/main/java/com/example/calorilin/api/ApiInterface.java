package com.example.calorilin.api;

import com.example.calorilin.model.disease.DiseaseItem;
import com.example.calorilin.model.foodmaterial.FoodMaterialItem;
import com.example.calorilin.model.foodmaterialfavpost.Materialfavpost;
import com.example.calorilin.model.login.Login;
import com.example.calorilin.model.recipes.Recipes;
import com.example.calorilin.model.recipes.RecipesItem;
import com.example.calorilin.model.register.Register;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login")
    Call<Login> loginResponse(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<Register> registerResponse(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
            );

    @GET("recipes")
    Call<List<RecipesItem>> recipesResponse(
            @Header("Authorization") String token
    );

    @GET("recipes-find-by-disease")
    Call<List<DiseaseItem>> recipesFindByDiseaseResponse(
            @Header("Authorization") String token,
            @Query("disease") String disease
    );

    @GET("food-materials")
    Call<List<FoodMaterialItem>> foodMaterialResponse(
            @Header("Authorization") String token
    );

    @FormUrlEncoded
    @POST("food-material-favorites")
    Call<Materialfavpost> foodmaterialfavoritesResponse(
            @Field("time_show") String time_show
    );

//    @GET("User")
//    Call<List<RecipesItem>> recipesResponse(
//            @Header("Authorization") String token
//    );
}
