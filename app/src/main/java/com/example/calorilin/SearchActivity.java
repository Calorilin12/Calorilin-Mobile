package com.example.calorilin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.calorilin.adapter.CariAdapter;
import com.example.calorilin.adapter.MakananHariAdapter;
import com.example.calorilin.api.ApiClient;
import com.example.calorilin.api.ApiInterface;
import com.example.calorilin.model.recipes.RecipesItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    RecyclerView carimakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");

        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
        Call<List<RecipesItem>> call = methods.recipesResponse("Bearer " + token);

        call.enqueue(new Callback<List<RecipesItem>>() {
            @Override
            public void onResponse(Call<List<RecipesItem>> call, Response<List<RecipesItem>> response) {
                if (response.isSuccessful()) {
                    List<RecipesItem> resep = response.body();
                    Log.e("Test", "onResponse: code: " + response.code());
                    Toast.makeText(SearchActivity.this, "Berhasil", Toast.LENGTH_LONG).show();
                    System.out.println("berhasil");
                    carimakanan = findViewById(R.id.tampilcarimakanan);
                    CariAdapter adapter2 = new CariAdapter(getApplicationContext(), resep);
                    carimakanan.setLayoutManager(new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false));
                    carimakanan.setAdapter(adapter2);

                } else if (response.code() == 500) {
                    Toast.makeText(SearchActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RecipesItem>> call, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(SearchActivity.this, "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}