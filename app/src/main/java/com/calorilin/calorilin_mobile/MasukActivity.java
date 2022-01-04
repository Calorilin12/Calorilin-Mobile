package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.login.Login;

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

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!email.getText().toString().trim().isEmpty()){
                    email.setBackgroundResource(R.drawable.border5);
                }
                else {
                    email.setBackgroundResource(R.drawable.border2);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!password.getText().toString().trim().isEmpty()){
                    password.setBackgroundResource(R.drawable.border5);
                }
                else {
                    password.setBackgroundResource(R.drawable.border2);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masukEmail = email.getText().toString();
                String masukPass = password.getText().toString();

                if (masukEmail.length() == 0 || masukPass.length() == 0){
                    Toast.makeText(MasukActivity.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }

                ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
                Call<Login> call = methods.loginResponse(masukEmail, masukPass);

                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        if (response.code() == 201) {
                            String tokens = response.body().getTokens();
                            String iduser = String.valueOf(response.body().getUser().getId());

                            Log.e("Test", "onResponse: code: " + response.code());
                            Toast.makeText(MasukActivity.this, "Selamat Datang", Toast.LENGTH_LONG).show();

                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("tokens", tokens);
                            editor.putString("id", iduser);
                            editor.commit();

                            startActivity(new Intent(getApplicationContext(), Halaman.class));
                            finish();

                        } else if (response.code() != 201) {
                            Toast.makeText(MasukActivity.this, "Email atau password yang anda masukkan salah", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Log.e("test", "onFailure" + t.getMessage());
                        Toast.makeText(MasukActivity.this, "Server gagal", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}