package com.calorilin.calorilin_mobile;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.calorilin.calorilin_mobile.model.recipes.RecipesItem;

public class RincianMakanan extends AppCompatActivity {

    ImageView rincigambar,back;
    TextView rincijudul, rincidurasi, rinciporsi, rincikalori;
    TextView rincikomposisi,rincilangkah2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincian_makanan);

        back = findViewById(R.id.backrincimakanan);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RecipesItem resepitem = getIntent().getParcelableExtra("resepmakanan");

        rincigambar = findViewById(R.id.gambarrinci);
        Glide.with(rincigambar)
                .load("https://api.calorilin.me/recipe-detail-images/"+ resepitem.getRecipeImage()).into(rincigambar);

        rincijudul = findViewById(R.id.judulrincimakanan);
        rincijudul.setText(resepitem.getName());

        rincidurasi = findViewById(R.id.waktupembuatan);
        rincidurasi.setText(String.valueOf(resepitem.getDuration()) + " Menit");

        rinciporsi = findViewById(R.id.porsi);
        rinciporsi.setText(String.valueOf(resepitem.getTotalEater()) + " Orang");

        rincikalori = findViewById(R.id.kalori);
        rincikalori.setText(String.valueOf(resepitem.getTotalCalory())+" Kcal");

        rincikomposisi = findViewById(R.id.komposisidetail);
        rincikomposisi.setText(resepitem.getCompositions());

        rincilangkah2 = findViewById(R.id.langkah2detail);
        rincilangkah2.setText(resepitem.getStepsOfMake());
    }
}