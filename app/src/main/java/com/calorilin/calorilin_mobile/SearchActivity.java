package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.calorilin.calorilin_mobile.adapter.CariAdapter;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.recipes.RecipesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    RecyclerView carimakanan;
    EditText cari;
    String key;
    ImageView back;
    ArrayList<RecipesItem> listCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        cari = findViewById(R.id.cari);
        listCari = new ArrayList<>();

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");

        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
        Call<List<RecipesItem>> call = methods.recipesResponse("Bearer " + token);

        call.enqueue(new Callback<List<RecipesItem>>() {
            @Override
            public void onResponse(Call<List<RecipesItem>> call, Response<List<RecipesItem>> response) {
                if (response.isSuccessful()) {
                    List<RecipesItem> resep = response.body();
                    carimakanan = findViewById(R.id.tampilcarimakanan);

                    CariAdapter adapter2 = new CariAdapter(getApplicationContext(), resep);
                    carimakanan.setLayoutManager(new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false));
                    carimakanan.setAdapter(adapter2);

                    cari.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            ArrayList<RecipesItem> filteredlist = new ArrayList<>();
                            for (RecipesItem recipesItem:resep){
                                if (recipesItem.getName().toLowerCase().contains(s.toString())){
                                    filteredlist.add(recipesItem);
                                }
                            }
                            adapter2.filterlist(filteredlist);
                        }
                    });

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

        back = findViewById(R.id.img_back_search);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}