package com.example.calorilin.api;

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
}
