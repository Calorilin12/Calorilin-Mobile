package com.calorilin.calorilin_mobile;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.calorilin.calorilin_mobile.adapter.BahanFavoriteAdapter;
import com.calorilin.calorilin_mobile.adapter.BahanMakananInformasiAdapter;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.foodmaterial.FoodMaterialItem;
import com.calorilin.calorilin_mobile.model.materialfavtimeshow.MaterialfavtimeshowItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHitungKalori extends Fragment implements BahanMakananInformasiAdapter.OnClickBahanFavorit {

    EditText caribahan;
    RecyclerView menubahanmakanan;
    RecyclerView bahanFavorite;
    BahanMakananInformasiAdapter.OnClickBahanFavorit listener;
    View view;
    Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_count_calories, container, false);

        activity = requireActivity();

        SharedPreferences sp = getActivity().getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id","");

        caribahan = view.findViewById(R.id.searchMenu);
        menubahanmakanan = view.findViewById(R.id.viewinformasikalori);

        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
        Call<List<FoodMaterialItem>> call = methods.foodMaterialResponse("Bearer " + token);

        call.enqueue(new Callback<List<FoodMaterialItem>>() {
            @Override
            public void onResponse(Call<List<FoodMaterialItem>> call, Response<List<FoodMaterialItem>> response) {
                if (response.isSuccessful()) {
                    List<FoodMaterialItem> resep = response.body();

                    BahanMakananInformasiAdapter adapter2 = new BahanMakananInformasiAdapter(view.getContext(), resep, activity);
                    menubahanmakanan.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));

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
                }
            }

            @Override
            public void onFailure(Call<List<FoodMaterialItem>> call, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
            }
        });

        bahanFavorite = view.findViewById(R.id.bahanfavoriteinformasi);

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<List<MaterialfavtimeshowItem>> call2 = methods2.favShowTimeResponse("Bearer " + token,id,"Default");

        call2.enqueue(new Callback<List<MaterialfavtimeshowItem>>() {
            @Override
            public void onResponse(Call<List<MaterialfavtimeshowItem>> call2, Response<List<MaterialfavtimeshowItem>> response) {
                if (response.isSuccessful()) {
                    List<MaterialfavtimeshowItem> bahanfav = response.body();
                    BahanFavoriteAdapter adapter3 = new BahanFavoriteAdapter(view.getContext(), bahanfav, activity);
                    bahanFavorite.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
                    bahanFavorite.setAdapter(adapter3);
                } else if (response.code() == 500) {
                }
            }

            @Override
            public void onFailure(Call<List<MaterialfavtimeshowItem>> call2, Throwable t) {
                Log.e("test", "onFailure" + t.getMessage());
            }
        });

        return view;
    }

    @Override
    public void onLabel(String flag) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(R.layout.detail_bahan_makanan);

        bottomSheetDialog.show();
        Toast.makeText(requireContext(), "", Toast.LENGTH_LONG).show();
    }
}
