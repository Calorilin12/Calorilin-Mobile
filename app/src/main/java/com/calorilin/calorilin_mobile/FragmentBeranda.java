package com.calorilin.calorilin_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorilin.calorilin_mobile.adapter.KatgoriAdapter;
import com.calorilin.calorilin_mobile.adapter.MakananHariAdapter;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.recipes.RecipesItem;
import com.calorilin.calorilin_mobile.model.user.UserData;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBeranda extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView, resephariini;
    ArrayList<ObjekKatagori> listkat;
    ArrayList<ObjekResepHari> listresephariini;
    TextView halouser;
    TextView cari;
    ImageView daging,sayur,buah,minuman;
    ImageView rekomendasi, programharian;
    static int checkData;
    FlagOpening opening = new FlagOpening();
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.beranda, container, false);

        SharedPreferences sp = getActivity().getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id", "");

        halouser = view.findViewById(R.id.halo1);
        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<UserData> call2 = methods2.userResponse("Bearer " + token, id);

        call2.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call2, Response<UserData> response) {
                if (response.isSuccessful()) {
                    halouser.setText("Halo, " + response.body().getName());
                    DataPenyakit dataPenyakit = new DataPenyakit(response.body().getCholesterol(), response.body().getDiabetes(),
                            response.body().getHyperTension(),response.body().getUricAcid(),response.body().getStomachAcid());
                    checkData = response.body().getCholesterol() + response.body().getDiabetes()+
                            response.body().getHyperTension()+response.body().getUricAcid()+response.body().getStomachAcid();
                    System.out.println(checkData);
                } else if (response.code() == 500) {

                }
            }

            @Override
            public void onFailure(Call<UserData> call2, Throwable t) {
                Toast.makeText(requireContext(), "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        daging = view.findViewById(R.id.daging);
        daging.setOnClickListener(this);
        sayur = view.findViewById(R.id.sayur);
        sayur.setOnClickListener(this);
        buah = view.findViewById(R.id.buah);
        buah.setOnClickListener(this);
        minuman = view.findViewById(R.id.minuman);
        minuman.setOnClickListener(this);



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
                    Collections.reverse(resep);
                    Log.e("Test", "onResponse: code: " + response.code());
                    System.out.println("berhasil");
                    resephariini = view.findViewById(R.id.makananhari);
                    MakananHariAdapter adapter2 = new MakananHariAdapter(view.getContext(), resep);
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

        programharian = view.findViewById(R.id.programsehat);
        programharian.setOnClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        if (opening.openingBeranda == false) {
            opening.setOpeningBeranda(true);
            startActivity(new Intent(getActivity(), Halaman.class));
            getActivity().finish();
        }
        super.onResume();
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
            if (checkData != 0)
                startActivity(new Intent(requireActivity(), RekomendasiMakananActivity.class));
            else
                startActivity(new Intent(requireActivity(), RekomendasiDataKosong.class));
        } else if (v == programharian) {
            startActivity(new Intent(requireActivity(), ProgramHarian.class));
        }else if (v == daging) {
            startActivity(new Intent(requireActivity(), cariDaging.class));
        }else if (v == sayur) {
            startActivity(new Intent(requireActivity(), cariSayur.class));
        }else if (v == buah) {
            startActivity(new Intent(requireActivity(), cariBuah.class));
        }else if (v == minuman) {
            startActivity(new Intent(requireActivity(), cariMinuman.class));
        }
    }
}