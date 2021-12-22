package com.calorilin.calorilin_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calorilin.calorilin_mobile.ObjekKontrol;
import com.calorilin.calorilin_mobile.R;

import java.util.ArrayList;

public class Controlkaloriadapter extends RecyclerView.Adapter<Controlkaloriadapter.ViewHolder> {
    private ArrayList<ObjekKontrol> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;

    public Controlkaloriadapter(Context context, ArrayList<ObjekKontrol> list){
        this.context = context;
        this.data = list;
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<ObjekKontrol> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_makanankontrol, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namamakanan.setText(data.get(position).getNamamakanan());
        holder.kalorimakanan.setText(data.get(position).getKalorimakanan());
        holder.kontrol1.setText(data.get(position).getKontrol1());
        holder.kontrol2.setText(data.get(position).getKontrol2());
        holder.kontrol3.setText(data.get(position).getKontrol3());
        holder.hapus.setImageResource(R.drawable.ic_baseline_close_24);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    interface RecycleKlik{
        void onKlikItem(View view, int posisi);
    }

    void setKlikListener(RecycleKlik recycleKlik){
        this.lister = recycleKlik;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namamakanan;
        TextView kalorimakanan;
        TextView kontrol1;
        TextView kontrol2;
        TextView kontrol3;
        ImageView hapus;

        ViewHolder(View itemView) {
            super(itemView);
            namamakanan = itemView.findViewById(R.id.namamaknaankontrol);
            kalorimakanan = itemView.findViewById(R.id.kalorimakanan);
            kontrol1 = itemView.findViewById(R.id.kandunganmakanankontrol1);
            kontrol2 = itemView.findViewById(R.id.kandunganmakanankontrol2);
            kontrol3 = itemView.findViewById(R.id.kandunganmakanankontrol3);
            hapus = itemView.findViewById(R.id.btnhapus);

            itemView.setTag(itemView);

            itemView.setOnClickListener(view -> {
                if(lister != null) lister.onKlikItem(view, getAdapterPosition());
            });
        }
    }
}
