package com.example.calorilin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.calorilin.adapter.CariAdapter;
import com.example.calorilin.adapter.LabelRekomAdapter;
import com.example.calorilin.api.ApiClient;
import com.example.calorilin.api.ApiInterface;
import com.example.calorilin.listenerpack.LabelRekomListener;
import com.example.calorilin.model.recipes.RecipesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RekomendasiMakananActivity extends AppCompatActivity implements LabelRekomListener {

    ArrayList<ObjekLabelRekomen> labelRekomen;
    ArrayList<RecipesItem> listDiabetes,listKolesterol,listHipertensi;
    RecyclerView recyclerView,daftarrekomendasimakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi_makanan);

        listDiabetes = new ArrayList<>();
        listKolesterol = new ArrayList<>();
        listHipertensi = new ArrayList<>();

        recyclerView = findViewById(R.id.labelmakanan);
        tambahlabel();
        LabelRekomAdapter adapter = new LabelRekomAdapter(getApplicationContext(),labelRekomen, this::onLabel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");

        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
        Call<List<RecipesItem>> call = methods.recipesResponse("Bearer " + token);

        call.enqueue(new Callback<List<RecipesItem>>() {
            @Override
            public void onResponse(Call<List<RecipesItem>> call, Response<List<RecipesItem>> response) {
                if (response.isSuccessful()) {
                    List<RecipesItem> resep = response.body();
                    Toast.makeText(RekomendasiMakananActivity.this, "Berhasil", Toast.LENGTH_LONG).show();
                    filterresep(resep);
//                    daftarrekomendasimakanan = findViewById(R.id.daftarmakananrekomendasi);
//                    CariAdapter adapter2 = new CariAdapter(getApplicationContext(), resep);
//                    daftarrekomendasimakanan.setLayoutManager(new LinearLayoutManager(RekomendasiMakananActivity.this, LinearLayoutManager.VERTICAL, false));
//                    daftarrekomendasimakanan.setAdapter(adapter2);

                } else if (response.code() == 500) {
                    Toast.makeText(RekomendasiMakananActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RecipesItem>> call, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(RekomendasiMakananActivity.this, "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void tambahlabel() {
        labelRekomen = new ArrayList<>();
        labelRekomen.add(new ObjekLabelRekomen("Kolesterol"));
        labelRekomen.add(new ObjekLabelRekomen("Diabetes"));
        labelRekomen.add(new ObjekLabelRekomen("Hipertensi"));
        labelRekomen.add(new ObjekLabelRekomen("Tua"));
    }

    @Override
    public void onLabel(String flag) {
        System.out.println("test :"+ flag);
        daftarrekomendasimakanan = findViewById(R.id.daftarmakananrekomendasi);
        CariAdapter adapter2 = null;

        if (flag.equals("Kolesterol")){
            adapter2 = new CariAdapter(getApplicationContext(), listKolesterol);
        }
        if (flag.equals("Diabetes")){
            adapter2 = new CariAdapter(getApplicationContext(), listDiabetes);
        }
        if (flag.equals("Hipertensi")){
            adapter2 = new CariAdapter(getApplicationContext(), listHipertensi);
        }
        daftarrekomendasimakanan.setLayoutManager(new LinearLayoutManager(RekomendasiMakananActivity.this, LinearLayoutManager.VERTICAL, false));
        daftarrekomendasimakanan.setAdapter(adapter2);
    }
    public void filterresep(List<RecipesItem> resep){

        for (RecipesItem recipesItem:resep){
            if(recipesItem.getCholesterol() == 0){
                listKolesterol.add(recipesItem);
            }
            if (recipesItem.getDiabetes() == 0){
                listDiabetes.add(recipesItem);
            }
            if (recipesItem.getHyperTension() == 0){
                listHipertensi.add(recipesItem);
            }
        }
    }
}