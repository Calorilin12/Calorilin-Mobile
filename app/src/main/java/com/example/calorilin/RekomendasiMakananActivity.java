package com.example.calorilin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.calorilin.adapter.LabelRekomAdapter;

import java.util.ArrayList;

public class RekomendasiMakananActivity extends AppCompatActivity {

    ArrayList<ObjekLabelRekomen> labelRekomen;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi_makanan);

        recyclerView = findViewById(R.id.labelmakanan);
        tambahlabel();
        LabelRekomAdapter adapter = new LabelRekomAdapter(getApplicationContext(),labelRekomen);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    private void tambahlabel() {
        labelRekomen = new ArrayList<>();
        labelRekomen.add(new ObjekLabelRekomen("Kolesterol"));
        labelRekomen.add(new ObjekLabelRekomen("Diabetes"));
        labelRekomen.add(new ObjekLabelRekomen("Hipertensi"));
        labelRekomen.add(new ObjekLabelRekomen("Tua"));
    }
}