package com.example.calorilin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calorilin.adapter.KatgoriAdapter;
import com.example.calorilin.adapter.MakananHariAdapter;

import java.util.ArrayList;

public class FragmentHitungKalori extends Fragment{
    Button pengaturan,keluar;
    ImageView lengkapidata;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_count_calories, container, false);


        return view;
    }
}
