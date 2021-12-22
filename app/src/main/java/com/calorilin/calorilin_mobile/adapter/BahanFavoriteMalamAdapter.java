package com.calorilin.calorilin_mobile.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calorilin.calorilin_mobile.DataControlTotal;
import com.calorilin.calorilin_mobile.R;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.hapusbahanfav.DelBahanFav;
import com.calorilin.calorilin_mobile.model.materialfavtimeshow.MaterialfavtimeshowItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BahanFavoriteMalamAdapter extends RecyclerView.Adapter<BahanFavoriteMalamAdapter.ViewHolder> {
    private List<MaterialfavtimeshowItem> data = new ArrayList<>();
    private RecycleKlik lister;
    private LayoutInflater inflater;
    private Context context;
    DataControlTotal dataControlTotal = new DataControlTotal();

    public BahanFavoriteMalamAdapter(Context context, List<MaterialfavtimeshowItem> list){
        this.context = context;
        this.data = list;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<MaterialfavtimeshowItem> items){
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
        MaterialfavtimeshowItem foodMaterialsItem = data.get(position);
        holder.namamakanankontrol.setText(foodMaterialsItem.getName());
        holder.kalori.setText(String.valueOf(foodMaterialsItem.getCalory())+"Kcal");
        holder.lemak.setText(String.valueOf(foodMaterialsItem.getFat())+"Kcal");
        holder.protein.setText(String.valueOf(foodMaterialsItem.getProtein())+"Kcal");
        holder.karbo.setText(String.valueOf(foodMaterialsItem.getCarbo())+"Kcal");
        holder.karbo.setText(String.valueOf(foodMaterialsItem.getCarbo())+"Kcal");

        dataControlTotal.tambahtotalMalam(foodMaterialsItem.getCalory());

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
                        } else if (response.code() == 500) {

                        }
                    }

                    @Override
                    public void onFailure(Call<DelBahanFav> call2, Throwable t) {

                    }
                });
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
        TextView namamakanankontrol;
        TextView kalori;
        TextView protein;
        TextView lemak;
        TextView karbo;
        ImageView hapusbahan;


        ViewHolder(View itemView) {
            super(itemView);
            namamakanankontrol = itemView.findViewById(R.id.namamaknaankontrol);
            kalori = itemView.findViewById(R.id.kalorimakanan);
            protein = itemView.findViewById(R.id.kandunganmakanankontrol1);
            lemak = itemView.findViewById(R.id.kandunganmakanankontrol2);
            karbo = itemView.findViewById(R.id.kandunganmakanankontrol3);
            hapusbahan = itemView.findViewById(R.id.btnhapus);
            itemView.setTag(itemView);

            itemView.setOnClickListener(view -> {
                if(lister != null) lister.onKlikItem(view, getAdapterPosition());
            });
        }
    }
}
