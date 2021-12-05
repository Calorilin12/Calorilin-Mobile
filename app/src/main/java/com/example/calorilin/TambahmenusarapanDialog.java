package com.example.calorilin;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorilin.adapter.BahanMakananAdapter;
import com.example.calorilin.adapter.CariAdapter;
import com.example.calorilin.api.ApiClient;
import com.example.calorilin.api.ApiInterface;
import com.example.calorilin.model.foodmaterial.FoodMaterialItem;
import com.example.calorilin.model.recipes.RecipesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahmenusarapanDialog extends AppCompatDialogFragment {
    RecyclerView bahanmakanan;
    EditText cari;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.tambahmenu_dialog,null);

        builder.setView(view).setTitle("Tambah Menu").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        SharedPreferences sp = getActivity().getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");

        cari = view.findViewById(R.id.caridialog);

        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
        Call<List<FoodMaterialItem>> call = methods.foodMaterialResponse("Bearer " + token);

        call.enqueue(new Callback<List<FoodMaterialItem>>() {
            @Override
            public void onResponse(Call<List<FoodMaterialItem>> call, Response<List<FoodMaterialItem>> response) {
                if (response.isSuccessful()) {
                    List<FoodMaterialItem> resep = response.body();
                    Toast.makeText(requireContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    bahanmakanan = view.findViewById(R.id.bahanmakananrecycle);

                    BahanMakananAdapter adapter2 = new BahanMakananAdapter(getActivity().getApplicationContext(), resep);
                    bahanmakanan.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
                    bahanmakanan.setAdapter(adapter2);

                    cari.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
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
                    Toast.makeText(requireContext(), "Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<FoodMaterialItem>> call, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
                Toast.makeText(requireContext(), "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
}
