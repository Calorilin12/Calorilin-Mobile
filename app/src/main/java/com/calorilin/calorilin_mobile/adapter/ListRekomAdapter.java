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
import com.calorilin.calorilin_mobile.model.disease.DiseaseItem;

import java.util.ArrayList;
import java.util.List;

public class ListRekomAdapter extends RecyclerView.Adapter<ListRekomAdapter.ViewHolder> {
    private List<DiseaseItem> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;

    public ListRekomAdapter(Context context, List<DiseaseItem> list){
        this.context = context;
        this.data = list;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<DiseaseItem> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_carimakanan, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DiseaseItem resepitem = data.get(position);
        holder.namamakanancari.setText(resepitem.getName());
        Glide.with(holder.gambarmakanan.getContext())
                .load("https://api.calorilin.me/recipe-detail-images/"+ resepitem.getRecipeImage()).apply(new RequestOptions().override(600, 200)).into(holder.gambarmakanan);

//        holder.gambarmakanan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, RincianMakanan.class);
//                intent.putExtra("rekomendasi", resepitem);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

//    public void filterlist(ArrayList<RecipesItem> filteredlist) {
//        data = filteredlist;
//        notifyDataSetChanged();
//    }

    interface RecycleKlik{
        void onKlikItem(View view, int posisi);
    }

    void setKlikListener(RecycleKlik recycleKlik){
        this.lister = recycleKlik;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namamakanancari;
        ImageView gambarmakanan;

        ViewHolder(View itemView) {
            super(itemView);
            namamakanancari = itemView.findViewById(R.id.namamakanancari);
            gambarmakanan = itemView.findViewById(R.id.fotogambarcari);
            itemView.setTag(itemView);

            itemView.setOnClickListener(view -> {
                if(lister != null) lister.onKlikItem(view, getAdapterPosition());
            });
        }
    }
}
