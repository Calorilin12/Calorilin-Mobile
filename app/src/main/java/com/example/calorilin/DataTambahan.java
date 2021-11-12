package com.example.calorilin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataTambahan extends AppCompatActivity {

    Button kolesterollabel,diabeteslabel,hipertensilabel,asamuratlabel,asamlambunglabel;
    static boolean kolesterol =false,diabetes=false,hipertensi=false,asamurat=false,asamlambung=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_tambahan);

        kolesterollabel = findViewById(R.id.kolesterollabel);
        kolesterollabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = kolesterollabel.getBackground();
            @Override
            public void onClick(View view) {
                if (!kolesterol){
                    kolesterollabel.setBackgroundResource(R.drawable.shapehijau);
                    kolesterollabel.setTextColor(R.color.white);
                    kolesterol = true;
                }
                else{
                    kolesterollabel.setBackground(background);
                    kolesterol=false;
                }
            }
        });
        diabeteslabel = findViewById(R.id.diabeteslabel);
        diabeteslabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = diabeteslabel.getBackground();
            @Override
            public void onClick(View view) {
                if (!diabetes){
                    diabeteslabel.setBackgroundResource(R.drawable.shapehijau);
                    diabetes = true;
                }
                else{
                    diabeteslabel.setBackground(background);
                    diabetes=false;
                }
            }
        });

        hipertensilabel = findViewById(R.id.hipertensilabel);
        hipertensilabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = hipertensilabel.getBackground();
            @Override
            public void onClick(View view) {
                if (!hipertensi){
                    hipertensilabel.setBackgroundResource(R.drawable.shapehijau);
                    hipertensi = true;
                }
                else{
                    hipertensilabel.setBackground(background);
                    hipertensi=false;
                }
            }
        });

        asamuratlabel = findViewById(R.id.asamuratlabel);
        asamuratlabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = asamuratlabel.getBackground();
            @Override
            public void onClick(View view) {
                if (!asamurat){
                    asamuratlabel.setBackgroundResource(R.drawable.shapehijau);
                    asamurat = true;
                }
                else{
                    asamuratlabel.setBackground(background);
                    asamurat=false;
                }
            }
        });

        asamlambunglabel = findViewById(R.id.asamlambunglabel);
        asamlambunglabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = asamlambunglabel.getBackground();
            @Override
            public void onClick(View view) {
                if (!asamlambung){
                    asamlambunglabel.setBackgroundResource(R.drawable.shapehijau);
                    asamlambung = true;
                }
                else{
                    asamlambunglabel.setBackground(background);
                    asamlambung=false;
                }
            }
        });
    }
}