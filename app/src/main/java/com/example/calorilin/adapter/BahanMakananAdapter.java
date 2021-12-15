package com.example.calorilin.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.calorilin.FlagTimeShow;
import com.example.calorilin.FragmentKontrolKalori;
import com.example.calorilin.R;
import com.example.calorilin.RincianMakanan;
import com.example.calorilin.TambahmenusarapanDialog;
import com.example.calorilin.api.ApiClient;
import com.example.calorilin.api.ApiInterface;
import com.example.calorilin.model.foodmaterial.FoodMaterialItem;
import com.example.calorilin.model.foodmaterialfavpost.Materialfavpost;
import com.example.calorilin.model.recipes.RecipesItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BahanMakananAdapter extends RecyclerView.Adapter<BahanMakananAdapter.ViewHolder> {
    private List<FoodMaterialItem> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;
    FlagTimeShow flagTimeShow = new FlagTimeShow();

    public BahanMakananAdapter(Context context, List<FoodMaterialItem> list){
        this.context = context;
        this.data = list;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<FoodMaterialItem> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
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
        holder.jumlahkaloribahan.setText(String.valueOf(bahanmakanan.getCalory())+"Kcal");
        Glide.with(holder.gambarbahanmakanan.getContext())
                .load("http://192.168.194.60:8000/Food-material-images/"+ bahanmakanan.getImage()).apply(new RequestOptions().override(200, 100)).into(holder.gambarbahanmakanan);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = context.getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
                String token = sp.getString("tokens", "");
                String id = sp.getString("id", "");

                ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
                Call<Materialfavpost> call = methods.foodmaterialfavoritesResponse(id, String.valueOf(bahanmakanan.getId()), "Bearer " + token, flagTimeShow.getTimeshownow());

                call.enqueue(new Callback<Materialfavpost>() {
                    @Override
                    public void onResponse(Call<Materialfavpost> call, Response<Materialfavpost> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            ((Activity)context).finish();
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
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void filterlist(ArrayList<FoodMaterialItem> filteredlist) {
        data = filteredlist;
        notifyDataSetChanged();
    }

    interface RecycleKlik{
        void onKlikItem(View view, int posisi);
    }

    void setKlikListener(RecycleKlik recycleKlik){
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
                if(lister != null) lister.onKlikItem(view, getAdapterPosition());
            });
        }
    }
}
