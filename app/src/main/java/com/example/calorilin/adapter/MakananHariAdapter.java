package com.example.calorilin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorilin.ObjekResepHari;
import com.example.calorilin.R;

import java.util.ArrayList;

public class MakananHariAdapter extends RecyclerView.Adapter<MakananHariAdapter.ViewHolder> {
    private ArrayList<ObjekResepHari> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;

    public MakananHariAdapter(Context context, ArrayList<ObjekResepHari> list){
        this.context = context;
        this.data = list;
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<ObjekResepHari> items){
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
        holder.namamakanan.setText(data.get(position).getNamaresep());
        holder.resto.setText(data.get(position).getResto());
        holder.level.setText(data.get(position).getLevel());
        holder.tanggalresep.setText(data.get(position).getWaktu());
        holder.gambarmakanan.setImageResource(data.get(position).getGambar());
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
