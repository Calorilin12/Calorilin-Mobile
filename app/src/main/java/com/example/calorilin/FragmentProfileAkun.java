package com.example.calorilin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorilin.adapter.KatgoriAdapter;
import com.example.calorilin.adapter.MakananHariAdapter;

import java.util.ArrayList;

public class FragmentProfileAkun extends Fragment {

    Button pengaturan;
    RecyclerView resepfaview;
    ArrayList<ObjekResepHari> listresepfav;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profileakun, container, false);

        pengaturan = view.findViewById(R.id.pegaturanprofile);
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Pengaturan.class);
                startActivity(intent);
            }
        });

        resepfaview = view.findViewById(R.id.resepfaavview);
        tambahresephariini();
        MakananHariAdapter adapter2 = new MakananHariAdapter(getActivity().getApplicationContext(), listresepfav);
        resepfaview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        resepfaview.setAdapter(adapter2);

        return view;
    }
    private void tambahresephariini() {
        listresepfav = new ArrayList<>();
        listresepfav.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam panggang", "by Pura Kitchen", "Mudah","20 Mei 2021"));
        listresepfav.add(new ObjekResepHari(R.drawable.makanan, "Nasi ayam Bakar", "by Nanda Kitchen", "Susah","19 Mei 2021"));
    }
}
