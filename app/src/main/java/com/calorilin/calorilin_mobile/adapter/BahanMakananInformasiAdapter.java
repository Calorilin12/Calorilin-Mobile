package com.calorilin.calorilin_mobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.calorilin.calorilin_mobile.R;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.foodmaterial.FoodMaterialItem;
import com.calorilin.calorilin_mobile.model.foodmaterialfavpost.Materialfavpost;
import com.calorilin.calorilin_mobile.model.recipes.RecipesItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BahanMakananInformasiAdapter extends RecyclerView.Adapter<BahanMakananInformasiAdapter.ViewHolder> {
    private List<FoodMaterialItem> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;
    private Activity activity;

    public BahanMakananInformasiAdapter(Context context, List<FoodMaterialItem> list, Activity activity) {
        this.context = context;
        this.data = list;
        inflater = LayoutInflater.from(context);
        this.activity = activity;
    }

    public void setData(List<FoodMaterialItem> items) {
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    public interface OnClickBahanFavorit {
        public void onLabel(String flag);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_bahanmakanan, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodMaterialItem bahanmakanan = data.get(position);
        holder.namabahanmakanan.setText(bahanmakanan.getName());
        holder.jumlahkaloribahan.setText(String.valueOf(bahanmakanan.getCalory()) + "Kcal");
        Glide.with(holder.gambarbahanmakanan.getContext())
                .load("https://api.calorilin.me/food-material-images/" + bahanmakanan.getImage()).apply(new RequestOptions().override(200, 100)).into(holder.gambarbahanmakanan);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
                bottomSheetDialog.setContentView(R.layout.detail_bahan_makanan);

                TextView tvJudul = bottomSheetDialog.findViewById(R.id.judulBahanMakananfav);
                tvJudul.setText(bahanmakanan.getName());

                TextView tvPenyajian = bottomSheetDialog.findViewById(R.id.nilaiPenyajian);
                tvPenyajian.setText(bahanmakanan.getServe());

                TextView tvTipebahan = bottomSheetDialog.findViewById(R.id.isiTipeBahan);
                tvTipebahan.setText(bahanmakanan.getType());

                TextView tvKalori = bottomSheetDialog.findViewById(R.id.nilaiKalori);
                tvKalori.setText(String.valueOf(bahanmakanan.getCalory()));

                TextView tvKarbohidrat = bottomSheetDialog.findViewById(R.id.nilaiKarbo);
                tvKarbohidrat.setText(String.valueOf(bahanmakanan.getCarbo()) + " g");

                TextView tvLemak = bottomSheetDialog.findViewById(R.id.nilaiLemak);
                tvLemak.setText(String.valueOf(bahanmakanan.getFat()) + " g");

                TextView tvProtein = bottomSheetDialog.findViewById(R.id.nilaiProtein);
                tvProtein.setText(String.valueOf(bahanmakanan.getProtein()) + " g");

                Button simpan = bottomSheetDialog.findViewById(R.id.buttonSimpan);
                simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SharedPreferences sp = context.getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
                        String token = sp.getString("tokens", "");
                        String id = sp.getString("id", "");

                        ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
                        Call<Materialfavpost> call = methods.foodmaterialfavoritesResponse(id, String.valueOf(bahanmakanan.getId()), "Bearer " + token, "Default");

                        call.enqueue(new Callback<Materialfavpost>() {
                            @Override
                            public void onResponse(Call<Materialfavpost> call, Response<Materialfavpost> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    bottomSheetDialog.dismiss();
                                } else if (response.code() == 500) {

                                }
                            }

                            @Override
                            public void onFailure(Call<Materialfavpost> call, Throwable t) {
                                Toast.makeText(context, "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                bottomSheetDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void filterlist(ArrayList<FoodMaterialItem> filteredlist) {
        data = filteredlist;
        notifyDataSetChanged();
    }

    interface RecycleKlik {
        void onKlikItem(View view, int posisi);
    }

    void setKlikListener(RecycleKlik recycleKlik) {
        this.lister = recycleKlik;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namabahanmakanan;
        TextView jumlahkaloribahan;
        ImageView gambarbahanmakanan;

        ViewHolder(View itemView) {
            super(itemView);
            namabahanmakanan = itemView.findViewById(R.id.namabahanmakanan);
            gambarbahanmakanan = itemView.findViewById(R.id.fotobahanmakanan);
            jumlahkaloribahan = itemView.findViewById(R.id.jumlahkaloribahan);
            itemView.setTag(itemView);

            itemView.setOnClickListener(view -> {
                if (lister != null) lister.onKlikItem(view, getAdapterPosition());
            });
        }
    }
}
