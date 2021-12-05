package com.example.calorilin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calorilin.adapter.BahanMakananAdapter;
import com.example.calorilin.api.ApiClient;
import com.example.calorilin.api.ApiInterface;
import com.example.calorilin.model.foodmaterial.FoodMaterialItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahMenu extends AppCompatActivity {
    EditText caribahan;
    RecyclerView menubahanmakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_menu);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");

        caribahan = findViewById(R.id.cariMenuTambahan);
        menubahanmakanan = findViewById(R.id.menubahan);

        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
        Call<List<FoodMaterialItem>> call = methods.foodMaterialResponse("Bearer " + token);

        call.enqueue(new Callback<List<FoodMaterialItem>>() {
            @Override
            public void onResponse(Call<List<FoodMaterialItem>> call, Response<List<FoodMaterialItem>> response) {
                if (response.isSuccessful()) {
                    List<FoodMaterialItem> resep = response.body();
                    Toast.makeText(TambahMenu.this, "Berhasil", Toast.LENGTH_LONG).show();

                    BahanMakananAdapter adapter2 = new BahanMakananAdapter(getApplicationContext(), resep);
                    menubahanmakanan.setLayoutManager(new LinearLayoutManager(TambahMenu.this, LinearLayoutManager.VERTICAL, false));

                    caribahan.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            menubahanmakanan.setAdapter(adapter2);
                            ArrayList<FoodMaterialItem> filteredlist = new ArrayList<>();
                            for (FoodMaterialItem foodMaterialItem:resep){
                                if (foodMaterialItem.getName().toLowerCase().contains(s.toString())){
                                    filteredlist.add(foodMaterialItem);
                                }
                            }
                            adapter2.filterlist(filteredlist);
                        }
                    });

                } else if (response.code() == 500) {
                    Toast.makeText(TambahMenu.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FoodMaterialItem>> call, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(TambahMenu.this, "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}