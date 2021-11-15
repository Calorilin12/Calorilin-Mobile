package com.example.calorilin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorilin.adapter.KatgoriAdapter;
import com.example.calorilin.adapter.MakananHariAdapter;
import com.example.calorilin.api.ApiClient;
import com.example.calorilin.api.ApiInterface;
import com.example.calorilin.model.login.Login;
import com.example.calorilin.model.recipes.Recipes;
import com.example.calorilin.model.recipes.RecipesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBeranda extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView, resephariini;
    ArrayList<ObjekKatagori> listkat;
    ArrayList<ObjekResepHari> listresephariini;
    EditText cari;
    ImageView rekomendasi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beranda, container, false);

        SharedPreferences sp = getActivity().getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");

        recyclerView = view.findViewById(R.id.katgori);
        tambahkatagori();
        KatgoriAdapter adapter = new KatgoriAdapter(getActivity().getApplicationContext(), listkat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

//        resephariini = view.findViewById(R.id.makananhari);
//        tambahresephariini();
//        MakananHariAdapter adapter2 = new MakananHariAdapter(getActivity().getApplicationContext(), listresephariini);
//        resephariini.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        resephariini.setAdapter(adapter2);

        cari = view.findViewById(R.id.cari);
        cari.setOnClickListener(this);
        rekomendasi = view.findViewById(R.id.rekomendasi);
        rekomendasi.setOnClickListener(this);

        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
        Call<List<RecipesItem>> call = methods.recipesResponse("Bearer " + token);

        call.enqueue(new Callback<List<RecipesItem>>() {
            @Override
            public void onResponse(Call<List<RecipesItem>> call, Response<List<RecipesItem>> response) {
                if (response.isSuccessful()) {
                    List<RecipesItem> resep = response.body();
                    Log.e("Test", "onResponse: code: " + response.code());
                    Toast.makeText(requireContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    System.out.println("berhasil");
                    resephariini = view.findViewById(R.id.makananhari);
                    MakananHariAdapter adapter2 = new MakananHariAdapter(getActivity().getApplicationContext(), resep);
                    resephariini.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    resephariini.setAdapter(adapter2);
                } else if (response.code() == 500) {
                    Toast.makeText(requireContext(), "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RecipesItem>> call, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(requireContext(), "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void tambahresephariini() {
        listresephariini = new ArrayList<>();
        listresephariini.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam panggang", "by Pura Kitchen", "Mudah", "20 Mei 2021"));
        listresephariini.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam panggang", "by Pura Kitchen", "Mudah", "20 Mei 2021"));
        listresephariini.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam panggang", "by Pura Kitchen", "Mudah", "20 Mei 2021"));
        listresephariini.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam panggang", "by Pura Kitchen", "Mudah", "20 Mei 2021"));
    }

    void tambahkatagori() {
        listkat = new ArrayList<>();
        listkat.add(new ObjekKatagori(R.drawable.logopizza, "Pizza"));
        listkat.add(new ObjekKatagori(R.drawable.logosayur, "Sayur"));
        listkat.add(new ObjekKatagori(R.drawable.logosup, "Sup"));
        listkat.add(new ObjekKatagori(R.drawable.logosusu, "Susu"));
        listkat.add(new ObjekKatagori(R.drawable.logopizza, "Pizza"));
        listkat.add(new ObjekKatagori(R.drawable.logosayur, "Sayur"));
        listkat.add(new ObjekKatagori(R.drawable.logosup, "Sup"));
    }

    @Override
    public void onClick(View v) {
        if (v == cari) {
            startActivity(new Intent(requireActivity(), SearchActivity.class));
        } else if (v == rekomendasi) {
            startActivity(new Intent(requireActivity(), RekomendasiMakananActivity.class));
        }
    }
}