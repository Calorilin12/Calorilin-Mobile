package com.calorilin.calorilin_mobile;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.totalfavorite.TotalNutrisiItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataControlTotal extends Application {
    static public double totalkalori =0;
    static public double totalkaloripagi =0;
    static public double totalkalorisiang =0;
    static public double totalkalorimalam =0;
    private static DataControlTotal instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static DataControlTotal getInstance() {
        return instance;
    }

    public static double getTotalkalori() {
        totalkalori = totalkaloripagi+totalkalorisiang+totalkalorimalam;
        return totalkalori;
    }

    public static void setTotalkalori(double totalkalori) {
        DataControlTotal.totalkalori = totalkalori;
    }

    public static double getTotalkaloripagi() {
        return totalkaloripagi;
    }

    public static void setTotalkaloripagi(double totalkaloripagi) {
        DataControlTotal.totalkaloripagi = totalkaloripagi;
    }

    public static double getTotalkalorisiang() {
        return totalkalorisiang;
    }

    public static void setTotalkalorisiang(double totalkalorisiang) {
        DataControlTotal.totalkalorisiang = totalkalorisiang;
    }

    public static double getTotalkalorimalam() {
        return totalkalorimalam;
    }

    public static void setTotalkalorimalam(double totalkalorimalam) {
        DataControlTotal.totalkalorimalam = totalkalorimalam;
    }

    public static void tambahtotalPagi(double tambah) {
        totalkaloripagi = totalkaloripagi + tambah;
    }

    public static void tambahtotalSiang(double tambah) {
        totalkalorisiang = totalkalorisiang + tambah;
    }
    public static void tambahtotalMalam(double tambah) {
        totalkalorimalam = totalkalorimalam + tambah;
    }
    public static double updateTotal(){
        SharedPreferences sp = instance.getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id","");

        final double[] total = {0};

        ApiInterface methods4 = ApiClient.getClient().create(ApiInterface.class);
        Call<TotalNutrisiItem> call4 = methods4.nutrisiResponse("Bearer " + token,id,"Pagi");
        call4.enqueue(new Callback<TotalNutrisiItem>() {
            @Override
            public void onResponse(Call<TotalNutrisiItem> call4, Response<TotalNutrisiItem> response) {
                if (response.isSuccessful()) {
                     total[0] =  response.body().getCalories();
                } else if (response.code() == 500) {

                }
            }

            @Override
            public void onFailure(Call<TotalNutrisiItem> call4, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());

            }
        });
    return total[0];
    }
}
