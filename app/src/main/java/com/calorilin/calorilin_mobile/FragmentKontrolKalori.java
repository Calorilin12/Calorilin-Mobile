package com.calorilin.calorilin_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorilin.calorilin_mobile.adapter.BahanFavoriteMalamAdapter;
import com.calorilin.calorilin_mobile.adapter.BahanFavoritePagiAdapter;
import com.calorilin.calorilin_mobile.adapter.BahanFavoriteSiangAdapter;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.materialfavtimeshow.MaterialfavtimeshowItem;
import com.calorilin.calorilin_mobile.model.totalfavorite.TotalNutrisiItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentKontrolKalori extends Fragment{

    ConstraintLayout expandableViewBreakfast, expandableViewLunch, expandableViewDinner;
    Button arrowBtnBreakfast, arrowBtnLunch, arrowBtnDinner;
    CardView cardViewBreakfast, cardViewLunch, cardViewDinner;
    DataControlTotal dataControlTotal = new DataControlTotal();
    TextView totalCalori,totalCaloriPagi,totalCaloriSiang,totalCaloriMalam;
    TextView totalProteinPagi,totalProteinSiang,totalProteinMalam;
    TextView totalLemakPagi,totalLemakSiang,totalLemakMalam;
    TextView totalKarboPagi,totalKarboSiang,totalKarboMalam;
    RecyclerView bahanFavorite,kontrolsiang,kontrolmalam;
    ArrayList<ObjekKontrol> listkontrol;
    Button tambahmenusarapan,tambahmenusiang,tambahmenumalam;
    FlagTimeShow flagTimeShow = new FlagTimeShow();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_control_calories, container, false);

        SharedPreferences sp = getActivity().getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id","");

//        dataControlTotal.setTotalkaloripagi(0);
//        dataControlTotal.setTotalkalorisiang(0);
//        dataControlTotal.setTotalkalorimalam(0);

        final double[] totalcalori = {0};
        bahanFavorite = view.findViewById(R.id.kontrolpagi);
        kontrolsiang = view.findViewById(R.id.kontrolsiang);
        kontrolmalam = view.findViewById(R.id.kontrolmalam);

        expandableViewBreakfast = view.findViewById(R.id.expandableViewBreakfast);
        arrowBtnBreakfast = view.findViewById(R.id.buttonBreakfast);
        cardViewBreakfast = view.findViewById(R.id.jadwalMakanPagi);

        expandableViewLunch = view.findViewById(R.id.expandableViewLunch);
        arrowBtnLunch = view.findViewById(R.id.buttonlunch);
        cardViewLunch = view.findViewById(R.id.jadwalMakanSiang);

        expandableViewDinner = view.findViewById(R.id.expandableViewDinner);
        arrowBtnDinner = view.findViewById(R.id.buttonDinner);
        cardViewDinner = view.findViewById(R.id.jadwalMakanMalam);

        arrowBtnBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableViewBreakfast.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardViewBreakfast, new AutoTransition());
                    expandableViewBreakfast.setVisibility(View.VISIBLE);
                    arrowBtnBreakfast.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewBreakfast, new AutoTransition());
                    expandableViewBreakfast.setVisibility(View.GONE);
                    arrowBtnBreakfast.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });
        arrowBtnLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableViewLunch.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardViewLunch, new AutoTransition());
                    expandableViewLunch.setVisibility(View.VISIBLE);
                    arrowBtnLunch.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewLunch, new AutoTransition());
                    expandableViewLunch.setVisibility(View.GONE);
                    arrowBtnLunch.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });
        arrowBtnDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableViewDinner.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardViewDinner, new AutoTransition());
                    expandableViewDinner.setVisibility(View.VISIBLE);
                    arrowBtnDinner.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else {
                    TransitionManager.beginDelayedTransition(cardViewDinner, new AutoTransition());
                    expandableViewDinner.setVisibility(View.GONE);
                    arrowBtnDinner.setBackgroundResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });
        tambahmenusarapan = view.findViewById(R.id.addMenuBreakfast);
        tambahmenusarapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagTimeShow.setTimeshownow("Pagi");
                Intent intent = new Intent(getActivity(), TambahMenu.class);
                startActivity(intent);
            }
        });
        tambahmenusiang = view.findViewById(R.id.addMenuLunch);
        tambahmenusiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagTimeShow.setTimeshownow("Siang");
                Intent intent = new Intent(getActivity(), TambahMenu.class);
                startActivity(intent);
            }
        });
        tambahmenumalam = view.findViewById(R.id.addMenuDinner);
        tambahmenumalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagTimeShow.setTimeshownow("Malam");
                Intent intent = new Intent(getActivity(), TambahMenu.class);
                startActivity(intent);
            }
        });

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<List<MaterialfavtimeshowItem>> call2 = methods2.favShowTimeResponse("Bearer " + token,id,"Pagi");

        call2.enqueue(new Callback<List<MaterialfavtimeshowItem>>() {
            @Override
            public void onResponse(Call<List<MaterialfavtimeshowItem>> call2, Response<List<MaterialfavtimeshowItem>> response) {
                if (response.isSuccessful()) {
                    List<MaterialfavtimeshowItem> bahanfav = response.body();
                    Toast.makeText(requireContext(), "Berhasil bahan", Toast.LENGTH_LONG).show();
                    BahanFavoritePagiAdapter adapter3 = new BahanFavoritePagiAdapter(getActivity().getApplicationContext(), bahanfav);
                    bahanFavorite.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    bahanFavorite.setAdapter(adapter3);
                } else if (response.code() == 500) {
                    Toast.makeText(requireContext(), "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MaterialfavtimeshowItem>> call2, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(requireContext(), "Gagal : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
        Call<List<MaterialfavtimeshowItem>> call = methods.favShowTimeResponse("Bearer " + token,id,"Siang");
        call.enqueue(new Callback<List<MaterialfavtimeshowItem>>() {
            @Override
            public void onResponse(Call<List<MaterialfavtimeshowItem>> call, Response<List<MaterialfavtimeshowItem>> response) {
                if (response.isSuccessful()) {
                    List<MaterialfavtimeshowItem> bahanfavsiang = response.body();
                    Toast.makeText(requireContext(), "Berhasil bahan", Toast.LENGTH_LONG).show();
                    BahanFavoriteSiangAdapter adapter2 = new BahanFavoriteSiangAdapter(getActivity().getApplicationContext(), bahanfavsiang);
                    kontrolsiang.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    kontrolsiang.setAdapter(adapter2);
                } else if (response.code() == 500) {
                    Toast.makeText(requireContext(), "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MaterialfavtimeshowItem>> call, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(requireContext(), "Gagal : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        ApiInterface methods3 = ApiClient.getClient().create(ApiInterface.class);
        Call<List<MaterialfavtimeshowItem>> call3 = methods3.favShowTimeResponse("Bearer " + token,id,"Malam");
        call3.enqueue(new Callback<List<MaterialfavtimeshowItem>>() {
            @Override
            public void onResponse(Call<List<MaterialfavtimeshowItem>> call3, Response<List<MaterialfavtimeshowItem>> response) {
                if (response.isSuccessful()) {
                    List<MaterialfavtimeshowItem> bahanfavmalam = response.body();
                    Toast.makeText(requireContext(), "Berhasil bahan", Toast.LENGTH_LONG).show();
                    BahanFavoriteMalamAdapter adapter4 = new BahanFavoriteMalamAdapter(getActivity().getApplicationContext(), bahanfavmalam);
                    kontrolmalam.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                    kontrolmalam.setAdapter(adapter4);
                } else if (response.code() == 500) {
                    Toast.makeText(requireContext(), "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MaterialfavtimeshowItem>> call3, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(requireContext(), "Gagal : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        totalCaloriPagi = view.findViewById(R.id.totalKaloriBreakfast);
        totalProteinPagi = view.findViewById(R.id.totalKandungan1Breakfast);
        totalLemakPagi = view.findViewById(R.id.totalKandungan2Breakfast);
        totalKarboPagi = view.findViewById(R.id.totalKandungan3Breakfast);
        ApiInterface methods4 = ApiClient.getClient().create(ApiInterface.class);
        Call<TotalNutrisiItem> call4 = methods4.nutrisiResponse("Bearer " + token,id,"Pagi");
        call4.enqueue(new Callback<TotalNutrisiItem>() {
            @Override
            public void onResponse(Call<TotalNutrisiItem> call4, Response<TotalNutrisiItem> response) {
                if (response.isSuccessful()) {
                    totalcalori[0] = totalcalori[0] + response.body().getCalories();
                    totalCaloriPagi.setText(String.valueOf(response.body().getCalories()) + "Kcal");
                    totalProteinPagi.setText(String.valueOf(response.body().getProtein()) + "Kcal");
                    totalLemakPagi.setText(String.valueOf(response.body().getFat()) + "Kcal");
                    totalKarboPagi.setText(String.valueOf(response.body().getCarbo()) + "Kcal");
                } else if (response.code() == 500) {
                    Toast.makeText(requireContext(), "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TotalNutrisiItem> call4, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(requireContext(), "Gagal : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        totalCaloriSiang = view.findViewById(R.id.totalKalorisiang);
        totalProteinSiang = view.findViewById(R.id.totalKandungan1siang);
        totalLemakSiang = view.findViewById(R.id.totalKandungan2siang);
        totalKarboSiang = view.findViewById(R.id.totalKandungan3siang);
        ApiInterface methods5 = ApiClient.getClient().create(ApiInterface.class);
        Call<TotalNutrisiItem> call5 = methods5.nutrisiResponse("Bearer " + token,id,"Siang");
        call5.enqueue(new Callback<TotalNutrisiItem>() {
            @Override
            public void onResponse(Call<TotalNutrisiItem> call5, Response<TotalNutrisiItem> response) {
                if (response.isSuccessful()) {
                    totalcalori[0] = totalcalori[0] + response.body().getCalories();
                    totalCaloriSiang.setText(String.valueOf(response.body().getCalories()) + "Kcal");
                    totalProteinSiang.setText(String.valueOf(response.body().getProtein()) + "Kcal");
                    totalLemakSiang.setText(String.valueOf(response.body().getFat()) + "Kcal");
                    totalKarboSiang.setText(String.valueOf(response.body().getCarbo()) + "Kcal");
                } else if (response.code() == 500) {
                    Toast.makeText(requireContext(), "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TotalNutrisiItem> call5, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(requireContext(), "Gagal : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        totalCaloriMalam = view.findViewById(R.id.totalKalorimalam);
        totalProteinMalam = view.findViewById(R.id.totalKandungan1malam);
        totalLemakMalam = view.findViewById(R.id.totalKandungan2malam);
        totalKarboMalam = view.findViewById(R.id.totalKandungan3malam);
        ApiInterface methods6 = ApiClient.getClient().create(ApiInterface.class);
        Call<TotalNutrisiItem> call6 = methods5.nutrisiResponse("Bearer " + token,id,"Malam");
        call6.enqueue(new Callback<TotalNutrisiItem>() {
            @Override
            public void onResponse(Call<TotalNutrisiItem> call6, Response<TotalNutrisiItem> response) {
                if (response.isSuccessful()) {
                    totalcalori[0] = totalcalori[0] + response.body().getCalories();
                    totalCaloriMalam.setText(String.valueOf(response.body().getCalories()) + "Kcal");
                    totalProteinMalam.setText(String.valueOf(response.body().getProtein()) + "Kcal");
                    totalLemakMalam.setText(String.valueOf(response.body().getFat()) + "Kcal");
                    totalKarboMalam.setText(String.valueOf(response.body().getCarbo()) + "Kcal");
                } else if (response.code() == 500) {
                    Toast.makeText(requireContext(), "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TotalNutrisiItem> call6, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(requireContext(), "Gagal : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        totalCalori = view.findViewById(R.id.jumlahKalori);
        totalCalori.setText(String.valueOf(totalcalori[0]));

//        totalCalori = view.findViewById(R.id.jumlahKalori);
//        totalCalori.setText(String.valueOf(dataControlTotal.getTotalkalori()));
//
//        totalCaloriPagi = view.findViewById(R.id.totalKaloriBreakfast);
//        totalCaloriPagi.setText(String.valueOf(dataControlTotal.getTotalkaloripagi()) + " Kcal");
//
//        totalCaloriSiang = view.findViewById(R.id.totalKalorisiang);
//        totalCaloriSiang.setText(String.valueOf(dataControlTotal.getTotalkalorisiang()) + " Kcal");
//
//        totalCaloriMalam = view.findViewById(R.id.totalKalorimalam);
//        totalCaloriMalam.setText(String.valueOf(dataControlTotal.getTotalkalorimalam()) + " Kcal");

        return view;
    }
    private void tambahmaknanankalori() {
        listkontrol = new ArrayList<>();
        listkontrol.add(new ObjekKontrol("Telor Ceplok","780 Kcal","45 g","45 g", "45 g"));
        listkontrol.add(new ObjekKontrol("Telor Dadar","780 Kcal","45 g","45 g", "45 g"));
    }
    public  void openDialog(){
        TambahmenusarapanDialog tambahmenusarapanDialog = new TambahmenusarapanDialog();
        tambahmenusarapanDialog.show(getActivity().getSupportFragmentManager(), "menu sarapan");
    }
}
