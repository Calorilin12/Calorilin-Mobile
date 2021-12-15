package com.example.calorilin.api;

import com.example.calorilin.model.disease.DiseaseItem;
import com.example.calorilin.model.favoriteget.FavMaterialItem;
import com.example.calorilin.model.foodmaterial.FoodMaterialItem;
import com.example.calorilin.model.foodmaterialfavpost.Materialfavpost;
import com.example.calorilin.model.login.Login;
import com.example.calorilin.model.materialfavtimeshow.MaterialfavtimeshowItem;
import com.example.calorilin.model.recipes.RecipesItem;
import com.example.calorilin.model.register.Register;
import com.example.calorilin.model.user.UserData;
import com.example.calorilin.model.userpost.UserEdit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
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
    @POST("food-material-favorites/{id_user}/{id_food_material}")
    Call<Materialfavpost> foodmaterialfavoritesResponse(
            @Path("id_user") String idUser,
            @Path("id_food_material") String idFoodMaterial,
            @Header("Authorization") String token,
            @Field("time_show") String timeShow
    );

    @GET("food-material-favorites/{id}")
    Call<List<FavMaterialItem>> foodmaterialgetResponse(
            @Header("Authorization") String token,
            @Path("id") String idUser
    );

    @GET("users/{id}")
    Call<UserData> userResponse(
            @Header("Authorization") String token,
            @Path("id") String idUser
    );

    @FormUrlEncoded
    @POST("users/{id}?_method=PUT")
    Call<UserEdit> usereditResponse(
            @Path("id") String id,
            @Query("_method") String method,
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("food-material-favorites-by-time-show/{id_user}?time_show=Pagi")
    Call<List<MaterialfavtimeshowItem>> favShowTimeResponse(
            @Header("Authorization") String token,
            @Path("id_user") String idUser,
            @Query("time_show") String timeShow
    );
}
