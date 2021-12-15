package com.calorilin.calorilin_mobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.calorilin.calorilin_mobile.ObjekKatagori;
import com.calorilin.calorilin_mobile.R;

import java.util.ArrayList;

public class KatgoriAdapter extends RecyclerView.Adapter<KatgoriAdapter.ViewHolder> {
    private ArrayList<ObjekKatagori> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;

    public KatgoriAdapter(Context context, ArrayList<ObjekKatagori> list){
        this.context = context;
        this.data = list;
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<ObjekKatagori> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_catagori, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namaka.setText(data.get(position).getNamakat());
        holder.logoka.setImageResource(data.get(position).getGambar());
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
        TextView namaka;
        ImageView logoka;

        ViewHolder(View itemView) {
            super(itemView);
            namaka = itemView.findViewById(R.id.namaka);
            logoka = itemView.findViewById(R.id.logoka);
            itemView.setTag(itemView);

            itemView.setOnClickListener(view -> {
                if(lister != null) lister.onKlikItem(view, getAdapterPosition());
            });
        }
    }
}
