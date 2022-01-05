package com.calorilin.calorilin_mobile.api;

import com.calorilin.calorilin_mobile.model.dailyhealthy.Data;
import com.calorilin.calorilin_mobile.model.disease.DiseaseItem;
import com.calorilin.calorilin_mobile.model.favoriteget.FavMaterialItem;
import com.calorilin.calorilin_mobile.model.foodmaterial.FoodMaterialItem;
import com.calorilin.calorilin_mobile.model.foodmaterialfavpost.Materialfavpost;
import com.calorilin.calorilin_mobile.model.hapusbahanfav.DelBahanFav;
import com.calorilin.calorilin_mobile.model.login.Login;
import com.calorilin.calorilin_mobile.model.materialfavtimeshow.MaterialfavtimeshowItem;
import com.calorilin.calorilin_mobile.model.penggunaanapk.PenggunaanAppItem;
import com.calorilin.calorilin_mobile.model.recipes.RecipesItem;
import com.calorilin.calorilin_mobile.model.register.Register;
import com.calorilin.calorilin_mobile.model.reportbug.ReportBug;
import com.calorilin.calorilin_mobile.model.tentangkami.TentangkamiItem;
import com.calorilin.calorilin_mobile.model.totalfavorite.TotalNutrisiItem;
import com.calorilin.calorilin_mobile.model.user.UserData;
import com.calorilin.calorilin_mobile.model.userdetailspost.UserDetailPost;
import com.calorilin.calorilin_mobile.model.userpost.UserEdit;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    @GET("recipes-find-by-category")
    Call<List<RecipesItem>> recipesCatagoryResponse(
            @Header("Authorization") String token,
            @Query("category") String category
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
            @Header("Authorization") String token,
            @Path("id") String id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("user-details/{id}?_method=PUT")
    Call<UserDetailPost> editdetailResponse(
            @Header("Authorization") String token,
            @Path("id") String id,
            @Field("weight") int weight,
            @Field("height") int height,
            @Field("tension") String tension,
            @Field("cholesterol") int cholesterol,
            @Field("diabetes") int diabetes,
            @Field("uric_acid") int uric_acid,
            @Field("stomach_acid") int stomach_acid,
            @Field("hyper_tension") int hyper_tension
    );
    @Multipart
    @POST("user-details-image/{id}?_method=PUT")
    Call<UserDetailPost> editGambarResponse(
            @Header("Authorization") String token,
            @Path("id") String id,
            @Part MultipartBody.Part image
    );

    @GET("food-material-favorites-by-time-show/{id_user}?")
    Call<List<MaterialfavtimeshowItem>> favShowTimeResponse(
            @Header("Authorization") String token,
            @Path("id_user") String idUser,
            @Query("time_show") String timeShow
    );

    @GET("daily-healthy-activity/{id_user}")
    Call<Data> healthyResponse(
            @Header("Authorization") String token,
            @Path("id_user") String idUser
    );

    @GET("food-material-favorites-get-total-nutrition/{id_user}?")
    Call<TotalNutrisiItem> nutrisiResponse(
            @Header("Authorization") String token,
            @Path("id_user") String idUser,
            @Query("time_show") String timeShow
    );
    @GET("tentang-kami")
    Call<TentangkamiItem> tentangkamiResponse(
            @Header("Authorization") String token
    );
    @GET("penggunaan-aplikasi")
    Call<PenggunaanAppItem> penggunaanappResponse(
            @Header("Authorization") String token
    );

    @FormUrlEncoded
    @POST("report-bug/{id_user}")
    Call<ReportBug> reportBugResponse(
            @Path("id_user") String idUser,
            @Header("Authorization") String token,
            @Field("report_bug") String report_bug
    );

    @DELETE("food-material-favorites/{id}")
    Call<DelBahanFav> delbahanResponse(
            @Header("Authorization") String token,
            @Path("id") String id
    );
}
