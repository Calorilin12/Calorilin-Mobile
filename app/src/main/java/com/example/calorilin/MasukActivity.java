package com.example.calorilin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calorilin.api.ApiClient;
import com.example.calorilin.api.ApiInterface;
import com.example.calorilin.model.login.Login;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MasukActivity extends AppCompatActivity {

    Button masuk;
    TextView daftar;
    EditText email, password;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        daftar = findViewById(R.id.daftarSekarang);
        masuk = findViewById(R.id.masuk2);
        email = findViewById(R.id.emailMasuk);
        password = findViewById(R.id.passwordMasuk);

        sp = getSharedPreferences("sharepre", Context.MODE_PRIVATE);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Daftar.class));
            }
        });
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masukEmail = email.getText().toString();
                String masukPass = password.getText().toString();


                ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
                Call<Login> call = methods.loginResponse(masukEmail, masukPass);

                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        if (response.code() == 201) {
                            String tokens = response.body().getTokens();

                            Log.e("Test", "onResponse: code: " + response.code());
                            Toast.makeText(MasukActivity.this, "Selamat Datang", Toast.LENGTH_LONG).show();

                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("tokens", tokens);
                            editor.commit();

                            startActivity(new Intent(getApplicationContext(), Halaman.class));

                        } else if (response.code() == 500) {
                            Toast.makeText(MasukActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Log.e("test", "onFailure" + t.getMessage());
                    }
                });
            }
        });
    }
}