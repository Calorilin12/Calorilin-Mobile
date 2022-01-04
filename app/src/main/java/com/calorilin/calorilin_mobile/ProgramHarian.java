package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.dailyhealthy.Dailyhealthy;
import com.calorilin.calorilin_mobile.model.dailyhealthy.Data;
import com.calorilin.calorilin_mobile.model.user.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgramHarian extends AppCompatActivity {

    TextView nilaiTinggiBadan,nilaiberatbadan,hasilimt,program1,program2,program3;
    ConstraintLayout pushupcard, situpcard,laricard;
    TextView textProgram1,textProgram2,textProgram3,jumlahpolaminum,jumlahminum;
    Button btWork1,btWork2,btWork3,back;
    ImageView minum1,minum2,minum3,minum4,minum5,minum6,minum7,minum8;
    static boolean pushup=false,situp=false,lari=false;
    static boolean cekMinum1 = false,cekMinum2 = false,cekMinum3 = false,cekMinum4 = false,cekMinum5 = false,cekMinum6 = false,cekMinum7 = false,cekMinum8 = false;
    DataMinum dataMinum = new DataMinum();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_harian);

        nilaiTinggiBadan = findViewById(R.id.nilaiTinggiBadan);
        nilaiberatbadan = findViewById(R.id.nilaiBeratBadan);
        hasilimt = findViewById(R.id.hasilIMT);
        program1 = findViewById(R.id.nilaiProgramHarian1);
        program2 = findViewById(R.id.nilaiProgramHarian2);
        program3 = findViewById(R.id.nilaiProgramHarian3);
        pushupcard = findViewById(R.id.pushupcard);
        situpcard = findViewById(R.id.situpcard);
        laricard = findViewById(R.id.laricard);
        textProgram1 = findViewById(R.id.textProgramHarian1);
        textProgram2 = findViewById(R.id.textProgramHarian2);
        textProgram3 = findViewById(R.id.textProgramHarian3);
        btWork1 = findViewById(R.id.buttonWorkout1);
        btWork2 = findViewById(R.id.buttonWorkout2);
        btWork3 = findViewById(R.id.buttonWorkout3);
        jumlahpolaminum = findViewById(R.id.jumlahpolaminum);
        jumlahminum= findViewById(R.id.jumlahminum);
        minum1 = findViewById(R.id.minum1);
        minum2 = findViewById(R.id.minum2);
        minum3 = findViewById(R.id.minum3);
        minum4 = findViewById(R.id.minum4);
        minum5 = findViewById(R.id.minum5);
        minum6 = findViewById(R.id.minum6);
        minum7 = findViewById(R.id.minum7);
        minum8 = findViewById(R.id.minum8);

        back = findViewById(R.id.backButtonIMT);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));

        if (pushup){
            pushupcard.setBackgroundResource(R.drawable.shapehijau);
            program1.setTextColor(Color.WHITE);
            textProgram1.setTextColor(Color.WHITE);
            btWork1.setBackgroundResource(R.drawable.bulatputih);
            btWork1.setText("Done");
            btWork1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
        }
        if (situp){
            situpcard.setBackgroundResource(R.drawable.shapehijau);
            program2.setTextColor(Color.WHITE);
            textProgram2.setTextColor(Color.WHITE);
            btWork2.setBackgroundResource(R.drawable.bulatputih);
            btWork2.setText("Done");
            btWork2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
        }
        if (lari){
            laricard.setBackgroundResource(R.drawable.shapehijau);
            program3.setTextColor(Color.WHITE);
            textProgram3.setTextColor(Color.WHITE);
            btWork3.setBackgroundResource(R.drawable.bulatputih);
            btWork3.setText("Done");
            btWork3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
        }


        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id","");

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<Data> call2 = methods2.healthyResponse("Bearer " + token, id);

        call2.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call2, Response<Data> response) {
                if (response.isSuccessful()) {
                    nilaiTinggiBadan.setText(String.valueOf(response.body().getHeight()) + " Cm");
                    nilaiberatbadan.setText(String.valueOf(response.body().getWeight()) + " Kg");
                    program1.setText(String.valueOf(response.body().getPushUp()) + " Push Up");
                    program2.setText(String.valueOf(response.body().getSitUp()) + " Sit up");
                    program3.setText(String.valueOf(response.body().getRun()) + " Menit Lari");
                    hasilimt.setText(response.body().getBodyMassIndex());

                } else if (response.code() == 500) {

                }
            }

            @Override
            public void onFailure(Call<Data> call2, Throwable t) {
                Toast.makeText(ProgramHarian.this, "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        pushupcard.setOnClickListener(new View.OnClickListener() {
            Drawable background = pushupcard.getBackground();

            @Override
            public void onClick(View v) {
                if (!pushup){
                    pushupcard.setBackgroundResource(R.drawable.shapehijau);
                    program1.setTextColor(Color.WHITE);
                    textProgram1.setTextColor(Color.WHITE);
                    btWork1.setBackgroundResource(R.drawable.bulatputih);
                    btWork1.setText("Done");
                    btWork1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
                    pushup = true;
                }
                else{
                    pushupcard.setBackgroundResource(R.drawable.shapeputih);
                    program1.setTextColor(Color.BLACK);
                    textProgram1.setTextColor(Color.BLACK);
                    btWork1.setText("Start");
                    btWork1.setBackgroundResource(R.drawable.shapehijau20);
                    btWork1.setTextColor(Color.WHITE);
                    pushup = false;
                }
            }
        });

        btWork1.setOnClickListener(new View.OnClickListener() {
            Drawable background = pushupcard.getBackground();

            @Override
            public void onClick(View v) {
                if (!pushup){
                    pushupcard.setBackgroundResource(R.drawable.shapehijau);
                    program1.setTextColor(Color.WHITE);
                    textProgram1.setTextColor(Color.WHITE);
                    btWork1.setBackgroundResource(R.drawable.bulatputih);
                    btWork1.setText("Done");
                    btWork1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
                    pushup = true;
                }
                else{
                    pushupcard.setBackgroundResource(R.drawable.shapeputih);
                    program1.setTextColor(Color.BLACK);
                    textProgram1.setTextColor(Color.BLACK);
                    btWork1.setText("Start");
                    btWork1.setBackgroundResource(R.drawable.shapehijau20);
                    btWork1.setTextColor(Color.WHITE);
                    pushup = false;
                }
            }
        });

        situpcard.setOnClickListener(new View.OnClickListener() {
            Drawable background = situpcard.getBackground();

            @Override
            public void onClick(View v) {
                if (!situp){
                    situpcard.setBackgroundResource(R.drawable.shapehijau);
                    program2.setTextColor(Color.WHITE);
                    textProgram2.setTextColor(Color.WHITE);
                    btWork2.setBackgroundResource(R.drawable.bulatputih);
                    btWork2.setText("Done");
                    btWork2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
                    situp = true;
                }
                else{
                    situpcard.setBackgroundResource(R.drawable.shapeputih);
                    program2.setTextColor(Color.BLACK);
                    textProgram2.setTextColor(Color.BLACK);
                    btWork2.setText("Start");
                    btWork2.setBackgroundResource(R.drawable.shapehijau20);
                    btWork2.setTextColor(Color.WHITE);
                    situp = false;
                }
            }
        });

        btWork2.setOnClickListener(new View.OnClickListener() {
            Drawable background = situpcard.getBackground();

            @Override
            public void onClick(View v) {
                if (!situp){
                    situpcard.setBackgroundResource(R.drawable.shapehijau);
                    program2.setTextColor(Color.WHITE);
                    textProgram2.setTextColor(Color.WHITE);
                    btWork2.setBackgroundResource(R.drawable.bulatputih);
                    btWork2.setText("Done");
                    btWork2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
                    situp = true;
                }
                else{
                    situpcard.setBackgroundResource(R.drawable.shapeputih);
                    program2.setTextColor(Color.BLACK);
                    textProgram2.setTextColor(Color.BLACK);
                    btWork2.setText("Start");
                    btWork2.setBackgroundResource(R.drawable.shapehijau20);
                    btWork2.setTextColor(Color.WHITE);
                    situp = false;
                }
            }
        });

        laricard.setOnClickListener(new View.OnClickListener() {
            Drawable background = laricard.getBackground();

            @Override
            public void onClick(View v) {
                if (!lari){
                    laricard.setBackgroundResource(R.drawable.shapehijau);
                    program3.setTextColor(Color.WHITE);
                    textProgram3.setTextColor(Color.WHITE);
                    btWork3.setBackgroundResource(R.drawable.bulatputih);
                    btWork3.setText("Done");
                    btWork3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
                    lari = true;
                }
                else{
                    laricard.setBackgroundResource(R.drawable.shapeputih);
                    program3.setTextColor(Color.BLACK);
                    textProgram3.setTextColor(Color.BLACK);
                    btWork3.setText("Start");
                    btWork3.setBackgroundResource(R.drawable.shapehijau20);
                    btWork3.setTextColor(Color.WHITE);
                    lari = false;
                }
            }
        });

        btWork3.setOnClickListener(new View.OnClickListener() {
            Drawable background = laricard.getBackground();

            @Override
            public void onClick(View v) {
                if (!lari){
                    laricard.setBackgroundResource(R.drawable.shapehijau);
                    program3.setTextColor(Color.WHITE);
                    textProgram3.setTextColor(Color.WHITE);
                    btWork3.setBackgroundResource(R.drawable.bulatputih);
                    btWork3.setText("Done");
                    btWork3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.primary));
                    lari = true;
                }
                else{
                    laricard.setBackgroundResource(R.drawable.shapeputih);
                    program3.setTextColor(Color.BLACK);
                    textProgram3.setTextColor(Color.BLACK);
                    btWork3.setText("Start");
                    btWork3.setBackgroundResource(R.drawable.shapehijau20);
                    btWork3.setTextColor(Color.WHITE);
                    lari = false;
                }
            }
        });

        if (cekMinum1)
            minum1.setImageResource(R.drawable.gelashijau);
        if (cekMinum2)
            minum2.setImageResource(R.drawable.gelashijau);
        if (cekMinum3)
            minum3.setImageResource(R.drawable.gelashijau);
        if (cekMinum4)
            minum4.setImageResource(R.drawable.gelashijau);
        if (cekMinum5)
            minum5.setImageResource(R.drawable.gelashijau);
        if (cekMinum6)
            minum6.setImageResource(R.drawable.gelashijau);
        if (cekMinum7)
            minum7.setImageResource(R.drawable.gelashijau);
        if (cekMinum8)
            minum8.setImageResource(R.drawable.gelashijau);

        minum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cekMinum1) {
                    minum1.setImageResource(R.drawable.gelasabu);
                    dataMinum.kurangBanyakMinum();
                    cekMinum1 = false;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
                else {
                    minum1.setImageResource(R.drawable.gelashijau);
                    dataMinum.tambahBanyakMinum();
                    cekMinum1 = true;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
            }
        });
        minum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cekMinum2) {
                    minum2.setImageResource(R.drawable.gelasabu);
                    dataMinum.kurangBanyakMinum();
                    cekMinum2 = false;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
                else {
                    minum2.setImageResource(R.drawable.gelashijau);
                    dataMinum.tambahBanyakMinum();
                    cekMinum2 = true;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
            }
        });
        minum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cekMinum3) {
                    minum3.setImageResource(R.drawable.gelasabu);
                    dataMinum.kurangBanyakMinum();
                    cekMinum3 = false;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
                else {
                    minum3.setImageResource(R.drawable.gelashijau);
                    dataMinum.tambahBanyakMinum();
                    cekMinum3 = true;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
            }
        });
        minum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cekMinum4) {
                    minum4.setImageResource(R.drawable.gelasabu);
                    dataMinum.kurangBanyakMinum();
                    cekMinum4 = false;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
                else {
                    minum4.setImageResource(R.drawable.gelashijau);
                    dataMinum.tambahBanyakMinum();
                    cekMinum4 = true;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
            }
        });
        minum5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cekMinum5) {
                    minum5.setImageResource(R.drawable.gelasabu);
                    dataMinum.kurangBanyakMinum();
                    cekMinum5 = false;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
                else {
                    minum5.setImageResource(R.drawable.gelashijau);
                    dataMinum.tambahBanyakMinum();
                    cekMinum5 = true;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
            }
        });
        minum6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cekMinum6) {
                    minum6.setImageResource(R.drawable.gelasabu);
                    dataMinum.kurangBanyakMinum();
                    cekMinum6 = false;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
                else {
                    minum6.setImageResource(R.drawable.gelashijau);
                    dataMinum.tambahBanyakMinum();
                    cekMinum6 = true;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
            }
        });
        minum7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cekMinum7) {
                    minum7.setImageResource(R.drawable.gelasabu);
                    dataMinum.kurangBanyakMinum();
                    cekMinum7 = false;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
                else {
                    minum7.setImageResource(R.drawable.gelashijau);
                    dataMinum.tambahBanyakMinum();
                    cekMinum7 = true;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
            }
        });

        minum8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cekMinum8) {
                    minum8.setImageResource(R.drawable.gelasabu);
                    dataMinum.kurangBanyakMinum();
                    cekMinum8 = false;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
                else {
                    minum8.setImageResource(R.drawable.gelashijau);
                    dataMinum.tambahBanyakMinum();
                    cekMinum8 = true;
                    jumlahminum.setText(String.valueOf(dataMinum.getBanyakMinum()));
                }
            }
        });

    }
}