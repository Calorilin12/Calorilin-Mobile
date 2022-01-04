package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private int loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sp.contains("tokens")){
                    Intent home=new Intent(MainActivity.this, Halaman.class);
                    startActivity(home);
                }
                else {
                    Intent home = new Intent(MainActivity.this, MasukActivity.class);
                    startActivity(home);
                }
                finish();

            }
        },loading);

    }
}