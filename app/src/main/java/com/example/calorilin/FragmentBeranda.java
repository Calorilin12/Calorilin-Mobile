package com.example.calorilin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorilin.adapter.KatgoriAdapter;
import com.example.calorilin.adapter.MakananHariAdapter;

import java.util.ArrayList;

public class FragmentBeranda extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView, resephariini;
    ArrayList<ObjekKatagori> listkat;
    ArrayList<ObjekResepHari> listresephariini;
    EditText cari;
    ImageView rekomendasi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beranda, container, false);
        recyclerView = view.findViewById(R.id.katgori);
        tambahkatagori();
        KatgoriAdapter adapter = new KatgoriAdapter(getActivity().getApplicationContext(), listkat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        resephariini = view.findViewById(R.id.makananhari);
        tambahresephariini();
        MakananHariAdapter adapter2 = new MakananHariAdapter(getActivity().getApplicationContext(), listresephariini);
        resephariini.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        resephariini.setAdapter(adapter2);

        cari = view.findViewById(R.id.cari);
        cari.setOnClickListener(this);
        rekomendasi = view.findViewById(R.id.rekomendasi);
        rekomendasi.setOnClickListener(this);

        return view;
    }

    private void tambahresephariini() {
        listresephariini = new ArrayList<>();
        listresephariini.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam panggang", "by Pura Kitchen", "Mudah","20 Mei 2021"));
        listresephariini.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam panggang", "by Pura Kitchen", "Mudah","20 Mei 2021"));
        listresephariini.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam panggang", "by Pura Kitchen", "Mudah","20 Mei 2021"));
        listresephariini.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam panggang", "by Pura Kitchen", "Mudah","20 Mei 2021"));
    }

    void tambahkatagori() {
        listkat = new ArrayList<>();
        listkat.add(new ObjekKatagori(R.drawable.logopizza, "Pizza"));
        listkat.add(new ObjekKatagori(R.drawable.logosayur, "Sayur"));
        listkat.add(new ObjekKatagori(R.drawable.logosup, "Sup"));
        listkat.add(new ObjekKatagori(R.drawable.logosusu, "Susu"));
        listkat.add(new ObjekKatagori(R.drawable.logopizza, "Pizza"));
        listkat.add(new ObjekKatagori(R.drawable.logosayur, "Sayur"));
        listkat.add(new ObjekKatagori(R.drawable.logosup, "Sup"));
    }

    @Override
    public void onClick(View v) {
        if(v == cari){
            startActivity(new Intent(requireActivity(), SearchActivity.class));
        }else if(v == rekomendasi){
            startActivity(new Intent(requireActivity(), RekomendasiMakananActivity.class));
        }
    }
}