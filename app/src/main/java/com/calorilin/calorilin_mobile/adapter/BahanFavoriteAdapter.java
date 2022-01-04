package com.calorilin.calorilin_mobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.calorilin.calorilin_mobile.FlagFragment;
import com.calorilin.calorilin_mobile.Halaman;
import com.calorilin.calorilin_mobile.R;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.hapusbahanfav.DelBahanFav;
import com.calorilin.calorilin_mobile.model.materialfavtimeshow.MaterialfavtimeshowItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BahanFavoriteAdapter extends RecyclerView.Adapter<BahanFavoriteAdapter.ViewHolder> {
    private List<MaterialfavtimeshowItem> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;
    Activity activity;

    public BahanFavoriteAdapter(Context context, List<MaterialfavtimeshowItem> list, Activity activity){
        this.context = context;
        this.data = list;
        inflater = LayoutInflater.from(context);
        this.activity = activity;
    }

    public void setData(List<MaterialfavtimeshowItem> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_bahanfavoriteinformasi, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MaterialfavtimeshowItem foodMaterialsItem = data.get(position);
        holder.namabahanfav.setText(foodMaterialsItem.getName());
        holder.kalori.setText("Kalori (Per Sajian) : " + String.valueOf(foodMaterialsItem.getCalory())+"kal");

        Glide.with(holder.gambarmakanan.getContext())
                .load("https://api.calorilin.me/food-material-images/"+ foodMaterialsItem.getImage()).apply(new RequestOptions().override(200, 100)).into(holder.gambarmakanan);

        holder.hapusbahan.setImageResource(R.drawable.ic_baseline_close_24);
        holder.hapusbahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = context.getSharedPreferences("sharepre", Context.MODE_PRIVATE);
                String token = sp.getString("tokens", "");

                ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
                Call<DelBahanFav> call2 = methods2.delbahanResponse("Bearer " + token, String.valueOf(foodMaterialsItem.getId()));

                call2.enqueue(new Callback<DelBahanFav>() {
                    @Override
                    public void onResponse(Call<DelBahanFav> call2, Response<DelBahanFav> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(context, response.body().getMessage() , Toast.LENGTH_SHORT).show();
                            FlagFragment flagFragment = new FlagFragment();
                            flagFragment.cekFragment = true;
                            flagFragment.fragment2 = true;
                            Intent intent = new Intent(context, Halaman.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                            activity.finish();
                        } else if (response.code() == 500) {

                        }
                    }

                    @Override
                    public void onFailure(Call<DelBahanFav> call2, Throwable t) {

                    }
                });
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
                bottomSheetDialog.setContentView(R.layout.detail_bahan_makanan);

                TextView tvJudul = bottomSheetDialog.findViewById(R.id.judulBahanMakananfav);
                tvJudul.setText(foodMaterialsItem.getName());

                TextView tvPenyajian = bottomSheetDialog.findViewById(R.id.nilaiPenyajian);
                tvPenyajian.setText(foodMaterialsItem.getServe());

                TextView tvTipebahan = bottomSheetDialog.findViewById(R.id.isiTipeBahan);
                tvTipebahan.setText(foodMaterialsItem.getType());

                TextView tvKalori = bottomSheetDialog.findViewById(R.id.nilaiKalori);
                tvKalori.setText(String.valueOf(foodMaterialsItem.getCalory()));

                TextView tvKarbohidrat = bottomSheetDialog.findViewById(R.id.nilaiKarbo);
                tvKarbohidrat.setText(String.valueOf(foodMaterialsItem.getCarbo()) + " g");

                TextView tvLemak = bottomSheetDialog.findViewById(R.id.nilaiLemak);
                tvLemak.setText(String.valueOf(foodMaterialsItem.getFat()) + " g");

                TextView tvProtein = bottomSheetDialog.findViewById(R.id.nilaiProtein);
                tvProtein.setText(String.valueOf(foodMaterialsItem.getProtein()) + " g");

                Button simpan = bottomSheetDialog.findViewById(R.id.buttonSimpan);
                simpan.setVisibility(View.GONE);

                bottomSheetDialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    interface   RecycleKlik{
        void onKlikItem(View view, int posisi);
    }

    void setKlikListener(RecycleKlik recycleKlik){
        this.lister = recycleKlik;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namabahanfav;
        TextView kalori;
        ImageView gambarmakanan;
        ImageView hapusbahan;

        ViewHolder(View itemView) {
            super(itemView);
            namabahanfav = itemView.findViewById(R.id.namabahanfavorite);
            kalori = itemView.findViewById(R.id.kalorifavorite);
            gambarmakanan = itemView.findViewById(R.id.gambarbahanfav);
            hapusbahan = itemView.findViewById(R.id.btnhapusfav);
            itemView.setTag(itemView);

            itemView.setOnClickListener(view -> {
                if(lister != null) lister.onKlikItem(view, getAdapterPosition());
            });
        }
    }
}
