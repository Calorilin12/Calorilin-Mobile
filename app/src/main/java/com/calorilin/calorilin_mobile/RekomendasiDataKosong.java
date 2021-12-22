package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RekomendasiDataKosong extends AppCompatActivity {

    TextView klikdisini;
    ImageView backrekom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi_data_kosong);

        klikdisini = findViewById(R.id.klikdisini);
        klikdisini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DataTambahan.class));
            }
        });
        backrekom2 = findViewById(R.id.backRekomMakanan2);
        backrekom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}