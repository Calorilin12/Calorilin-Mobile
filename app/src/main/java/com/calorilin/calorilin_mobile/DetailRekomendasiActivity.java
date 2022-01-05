package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.calorilin.calorilin_mobile.model.disease.DiseaseItem;
import com.calorilin.calorilin_mobile.model.recipes.RecipesItem;

public class DetailRekomendasiActivity extends AppCompatActivity {

    ImageView rincigambar,back;
    TextView rincijudul, rincidurasi, rinciporsi, rincikalori;
    TextView rincikomposisi,rincilangkah2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rekomendasi);

        back = findViewById(R.id.backdetailrekom);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        DiseaseItem resepitem = getIntent().getParcelableExtra("rekomendasi");

        rincigambar = findViewById(R.id.gambarrekomendasi);
        Glide.with(rincigambar)
                .load("https://api.calorilin.me/recipe-detail-images/"+ resepitem.getRecipeImage()).into(rincigambar);

        rincijudul = findViewById(R.id.judulrincimakananrekomendasi);
        rincijudul.setText(resepitem.getName());

        rincidurasi = findViewById(R.id.waktupembuatanrekomendasi);
        rincidurasi.setText(String.valueOf(resepitem.getDuration()) + " Menit");

        rinciporsi = findViewById(R.id.porsirekomendasi);
        rinciporsi.setText(String.valueOf(resepitem.getTotalEater()) + " Orang");

        rincikalori = findViewById(R.id.kalorirekomendasi);
        rincikalori.setText(String.valueOf(resepitem.getTotalCalory())+" Kcal");

        rincikomposisi = findViewById(R.id.komposisidetailrekomendasi);
        rincikomposisi.setText(resepitem.getCompositions());

        rincilangkah2 = findViewById(R.id.langkah2detailrekomendasi);
        rincilangkah2.setText(resepitem.getStepsOfMake());
    }
}