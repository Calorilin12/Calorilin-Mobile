package com.example.calorilin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calorilin.api.ApiClient;
import com.example.calorilin.api.ApiInterface;
import com.example.calorilin.model.login.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MasukActivity extends AppCompatActivity {

    Button back,masuk;
    TextView daftar;
    EditText email,password;
    String etEmail,etPassword;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        back =findViewById(R.id.back);
        daftar = findViewById(R.id.daftarSekarang);
        masuk = findViewById(R.id.masuk2);
        email = findViewById(R.id.emailMasuk);
        password =findViewById(R.id.passwordMasuk);


        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Daftar.class));
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEmail = email.getText().toString();
                etPassword = password.getText().toString();
                apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<Login> loginCall = apiInterface.loginResponse(etEmail,etPassword);
                loginCall.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {

                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Toast.makeText(MasukActivity.this, "Selamat Datang Stefanus Irgy", Toast.LENGTH_SHORT).show();
                    }
                });

                startActivity(new Intent(getApplicationContext(),Halaman.class));
            }
        });
    }
}