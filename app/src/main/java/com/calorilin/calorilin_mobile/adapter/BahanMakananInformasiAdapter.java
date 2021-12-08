package com.calorilin.calorilin_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.calorilin.calorilin_mobile.R;
import com.calorilin.calorilin_mobile.model.foodmaterial.FoodMaterialItem;

import java.util.ArrayList;
import java.util.List;

public class BahanMakananInformasiAdapter extends RecyclerView.Adapter<BahanMakananInformasiAdapter.ViewHolder> {
    private List<FoodMaterialItem> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;

    public BahanMakananInformasiAdapter(Context context, List<FoodMaterialItem> list){
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
