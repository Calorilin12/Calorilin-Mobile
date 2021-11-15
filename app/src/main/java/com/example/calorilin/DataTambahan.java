package com.example.calorilin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.annotation.Resource;

public class DataTambahan extends AppCompatActivity {

    Button kolesterollabel, diabeteslabel, hipertensilabel, asamuratlabel, asamlambunglabel;
    static boolean kolesterol = false, diabetes = false, hipertensi = false, asamurat = false, asamlambung = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_tambahan);

        kolesterollabel = findViewById(R.id.kolesterollabel);
        kolesterollabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = kolesterollabel.getBackground();

            @Override
            public void onClick(View view) {

                if (!kolesterol) {
                    kolesterollabel.setBackgroundResource(R.drawable.shapehijau);
                    kolesterollabel.setTextColor(Color.WHITE);
                    kolesterol = true;
                } else {
                    kolesterollabel.setBackground(background);
                    kolesterollabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    kolesterol = false;
                }
            }
        });
        diabeteslabel = findViewById(R.id.diabeteslabel);
        diabeteslabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = diabeteslabel.getBackground();

            @Override
            public void onClick(View view) {
                if (!diabetes) {
                    diabeteslabel.setBackgroundResource(R.drawable.shapehijau);
                    kolesterollabel.setTextColor(Color.WHITE);
                    diabetes = true;
                } else {
                    diabeteslabel.setBackground(background);
                    kolesterollabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    diabetes = false;
                }
            }
        });

        hipertensilabel = findViewById(R.id.hipertensilabel);
        hipertensilabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = hipertensilabel.getBackground();

            @Override
            public void onClick(View view) {
                if (!hipertensi) {
                    hipertensilabel.setBackgroundResource(R.drawable.shapehijau);
                    kolesterollabel.setTextColor(Color.WHITE);
                    hipertensi = true;
                } else {
                    hipertensilabel.setBackground(background);
                    kolesterollabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    hipertensi = false;
                }
            }
        });

        asamuratlabel = findViewById(R.id.asamuratlabel);
        asamuratlabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = asamuratlabel.getBackground();

            @Override
            public void onClick(View view) {
                if (!asamurat) {
                    asamuratlabel.setBackgroundResource(R.drawable.shapehijau);
                    kolesterollabel.setTextColor(Color.WHITE);
                    asamurat = true;
                } else {
                    asamuratlabel.setBackground(background);
                    kolesterollabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    asamurat = false;
                }
            }
        });

        asamlambunglabel = findViewById(R.id.asamlambunglabel);
        asamlambunglabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = asamlambunglabel.getBackground();

            @Override
            public void onClick(View view) {
                if (!asamlambung) {
                    asamlambunglabel.setBackgroundResource(R.drawable.shapehijau);
                    kolesterollabel.setTextColor(Color.WHITE);
                    asamlambung = true;
                } else {
                    asamlambunglabel.setBackground(background);
                    kolesterollabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    asamlambung = false;
                }
            }
        });
    }
}