package com.calorilin.calorilin_mobile.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.calorilin.calorilin_mobile.RincianMakanan;
import com.calorilin.calorilin_mobile.model.recipes.RecipesItem;

import java.util.ArrayList;
import java.util.List;

public class MakananHariAdapter extends RecyclerView.Adapter<MakananHariAdapter.ViewHolder> {
    private List<RecipesItem> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;

    public MakananHariAdapter(Context context, List<RecipesItem> list){
        this.context = context;
        this.data = list;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<RecipesItem> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_makananhariini, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecipesItem resepitem = data.get(position);
        holder.namamakanan.setText(resepitem.getName());
        holder.resto.setText(resepitem.getMadeBy());
        holder.tanggalresep.setText(resepitem.getCreatedAt());
        holder.level.setText(resepitem.getLevelOfDifficult());

        Glide.with(holder.gambarmakanan.getContext())
                .load("http://192.168.194.60:8000/recipe-detail-images/"+ resepitem.getRecipeImage()).apply(new RequestOptions().override(600, 200)).into(holder.gambarmakanan);


        holder.gambarmakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RincianMakanan.class);
                intent.putExtra("resepmakanan", resepitem);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
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
        TextView namamakanan;
        TextView resto;
        TextView level;
        TextView tanggalresep;
        ImageView gambarmakanan;

        ViewHolder(View itemView) {
            super(itemView);
            namamakanan = itemView.findViewById(R.id.namamakanan);
            resto = itemView.findViewById(R.id.resto);
            level = itemView.findViewById(R.id.mudah);
            tanggalresep = itemView.findViewById(R.id.tanggalresep);
            gambarmakanan = itemView.findViewById(R.id.gambarmakanan);
            itemView.setTag(itemView);

            itemView.setOnClickListener(view -> {
                if(lister != null) lister.onKlikItem(view, getAdapterPosition());
            });
        }
    }
}
