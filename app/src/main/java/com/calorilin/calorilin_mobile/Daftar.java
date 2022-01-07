package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.calorilin.calorilin_mobile.model.register.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Daftar extends AppCompatActivity {

    Button back,daftar;
    TextView masuk;
    EditText emaildaftar,passdaftar,namadaftar;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        masuk = findViewById(R.id.masuksekarang);
        daftar = findViewById(R.id.daftar2);
        emaildaftar = findViewById(R.id.emailMasuk);
        passdaftar = findViewById(R.id.passwordMasuk);
        namadaftar = findViewById(R.id.namaPengguna);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MasukActivity.class));
                finish();
            }
        });

        emaildaftar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!emaildaftar.getText().toString().trim().isEmpty()){
                    emaildaftar.setBackgroundResource(R.drawable.border5);
                }
                else {
                    emaildaftar.setBackgroundResource(R.drawable.border2);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        namadaftar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!namadaftar.getText().toString().trim().isEmpty()){
                    namadaftar.setBackgroundResource(R.drawable.border5);
                }
                else {
                    namadaftar.setBackgroundResource(R.drawable.border2);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passdaftar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!passdaftar.getText().toString().trim().isEmpty()){
                    passdaftar.setBackgroundResource(R.drawable.border5);
                }
                else {
                    passdaftar.setBackgroundResource(R.drawable.border2);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEmail = emaildaftar.getText().toString();
                String newPass = passdaftar.getText().toString();
                String newName = namadaftar.getText().toString();

                if (newEmail.length() == 0 || newPass.length() == 0 || newName.length() == 0){
                    Toast.makeText(Daftar.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else if (newPass.length()<6){
                    Toast.makeText(Daftar.this, "Password harus lebih dari 6 karakter", Toast.LENGTH_SHORT).show();
                }
                else {
                    ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
                    Call<Register> call = methods.registerResponse(newName, newEmail, newPass);

                    call.enqueue(new Callback<Register>() {
                        @Override
                        public void onResponse(Call<Register> call, Response<Register> response) {
                            if (response.code() == 201) {

                                Toast.makeText(Daftar.this, "Berhasil daftar", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(), MasukActivity.class));
                                finish();
                            } else if (response.code() != 201) {

                            }
                        }

                        @Override
                        public void onFailure(Call<Register> call, Throwable t) {
                            Toast.makeText(Daftar.this, "Gagal", Toast.LENGTH_LONG).show();
                            Log.e("test", "onFailure" + t.getMessage());
                        }
                    });
                }
            }
        });
    }
}