package com.example.calorilin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorilin.ObjekLabelRekomen;
import com.example.calorilin.R;
import com.example.calorilin.listenerpack.LabelRekomListener;

import java.util.ArrayList;

public class LabelRekomAdapter extends RecyclerView.Adapter<LabelRekomAdapter.ViewHolder> {
    private ArrayList<ObjekLabelRekomen> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;
    private LabelRekomListener listener;

    public LabelRekomAdapter(Context context, ArrayList<ObjekLabelRekomen> list, LabelRekomListener listener){
        this.context = context;
        this.data = list;
        this.listener = listener;
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<ObjekLabelRekomen> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_labelrekomen, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ObjekLabelRekomen labelR = data.get(position);
        holder.namalabelrekomen.setText(data.get(position).getLabelRekomen());
        holder.namalabelrekomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(labelR.getLabelRekomen());
                listener.onLabel(labelR.getLabelRekomen());
            }
        });
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
        Button namalabelrekomen;

        ViewHolder(View itemView) {
            super(itemView);
            namalabelrekomen = itemView.findViewById(R.id.namalabel);

            itemView.setTag(itemView);

            itemView.setOnClickListener(view -> {
                if(lister != null) lister.onKlikItem(view, getAdapterPosition());
            });
        }
    }
}
