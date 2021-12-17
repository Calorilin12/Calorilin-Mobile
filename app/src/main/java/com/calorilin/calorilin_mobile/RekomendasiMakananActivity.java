package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.calorilin.calorilin_mobile.adapter.LabelRekomAdapter;
import com.calorilin.calorilin_mobile.adapter.ListRekomAdapter;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.listenerpack.LabelRekomListener;
import com.calorilin.calorilin_mobile.model.disease.DiseaseItem;
import com.calorilin.calorilin_mobile.model.recipes.RecipesItem;
import com.calorilin.calorilin_mobile.model.user.UserData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RekomendasiMakananActivity extends AppCompatActivity implements LabelRekomListener {

    ArrayList<ObjekLabelRekomen> labelRekomen;
    ArrayList<RecipesItem> listDiabetes,listKolesterol,listHipertensi;
    RecyclerView recyclerView,daftarrekomendasimakanan;
    String label = "Cholesterol";
    String token;
    SharedPreferences sp;

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

        sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        token = sp.getString("tokens", "");

//        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
//        Call<List<DiseaseItem>> call = methods.recipesFindByDiseaseResponse("Bearer " + token,label);
//
//
//        call.enqueue(new Callback<List<DiseaseItem>>() {
//            @Override
//            public void onResponse(Call<List<DiseaseItem>> call, Response<List<DiseaseItem>> response) {
//                if (response.isSuccessful()) {
//                    List<DiseaseItem> resep = response.body();
//                    Toast.makeText(RekomendasiMakananActivity.this, "Berhasil", Toast.LENGTH_LONG).show();
//                    //filterresep(resep);
//                    daftarrekomendasimakanan = findViewById(R.id.daftarmakananrekomendasi);
//                    ListRekomAdapter adapter2 = new ListRekomAdapter(getApplicationContext(), resep);
//                    daftarrekomendasimakanan.setLayoutManager(new LinearLayoutManager(RekomendasiMakananActivity.this, LinearLayoutManager.VERTICAL, false));
//                    daftarrekomendasimakanan.setAdapter(adapter2);
//
//                } else if (response.code() == 500) {
//                    Toast.makeText(RekomendasiMakananActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<DiseaseItem>> call, Throwable t) {
//                Log.e("test", "onFailure" + t.getMessage());
//                Toast.makeText(RekomendasiMakananActivity.this, "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void tambahlabel() {
        labelRekomen = new ArrayList<>();
        DataPenyakit dataPenyakit =new DataPenyakit();
        System.out.println(dataPenyakit.diabetes);
        if(dataPenyakit.cholesterol == 1){
            labelRekomen.add(new ObjekLabelRekomen("Cholesterol"));
        }
        if(dataPenyakit.diabetes == 1){
            labelRekomen.add(new ObjekLabelRekomen("Diabetes"));
        }
        if(dataPenyakit.hipertensi == 1){
            labelRekomen.add(new ObjekLabelRekomen("Hipertensi"));
        }
        if(dataPenyakit.asamUrat == 1){
            labelRekomen.add(new ObjekLabelRekomen("Asam Urat"));
        }
        if(dataPenyakit.asamLambung == 1){
            labelRekomen.add(new ObjekLabelRekomen("Asam Lambung"));
        }

    }

    @Override
    public void onLabel(String flag) {
        System.out.println("test :"+ flag);
        label = flag;
//        daftarrekomendasimakanan = findViewById(R.id.daftarmakananrekomendasi);
//        CariAdapter adapter2 = null;
//
//        if (flag.equals("Kolesterol")){
//            adapter2 = new CariAdapter(getApplicationContext(), listKolesterol);
//        }
//        if (flag.equals("Diabetes")){
//            adapter2 = new CariAdapter(getApplicationContext(), listDiabetes);
//        }
//        if (flag.equals("Hipertensi")){
//            adapter2 = new CariAdapter(getApplicationContext(), listHipertensi);
//        }
//        daftarrekomendasimakanan.setLayoutManager(new LinearLayoutManager(RekomendasiMakananActivity.this, LinearLayoutManager.VERTICAL, false));
//        daftarrekomendasimakanan.setAdapter(adapter2);

        token = sp.getString("tokens", "");

        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
        Call<List<DiseaseItem>> call = methods.recipesFindByDiseaseResponse("Bearer " + token,label);

        call.enqueue(new Callback<List<DiseaseItem>>() {
            @Override
            public void onResponse(Call<List<DiseaseItem>> call, Response<List<DiseaseItem>> response) {
                if (response.isSuccessful()) {
                    List<DiseaseItem> resep = response.body();
                    Toast.makeText(RekomendasiMakananActivity.this, "Berhasil", Toast.LENGTH_LONG).show();
                    //filterresep(resep);
                    daftarrekomendasimakanan = findViewById(R.id.daftarmakananrekomendasi);
                    ListRekomAdapter adapter2 = new ListRekomAdapter(getApplicationContext(), resep);
                    daftarrekomendasimakanan.setLayoutManager(new LinearLayoutManager(RekomendasiMakananActivity.this, LinearLayoutManager.VERTICAL, false));
                    daftarrekomendasimakanan.setAdapter(adapter2);

                } else if (response.code() == 500) {
                    Toast.makeText(RekomendasiMakananActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<DiseaseItem>> call, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(RekomendasiMakananActivity.this, "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
//    public void filterresep(List<RecipesItem> resep){
//
//        for (RecipesItem recipesItem:resep){
//            if(recipesItem.getCholesterol() == 0){
//                listKolesterol.add(recipesItem);
//            }
//            if (recipesItem.getDiabetes() == 0){
//                listDiabetes.add(recipesItem);
//            }
//            if (recipesItem.getHyperTension() == 0){
//                listHipertensi.add(recipesItem);
//            }
//        }
//    }
}