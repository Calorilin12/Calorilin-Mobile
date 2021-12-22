package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        back = findViewById(R.id.backpengaturan);
        daftar = findViewById(R.id.daftar2);
        emaildaftar = findViewById(R.id.emailMasuk);
        passdaftar = findViewById(R.id.passwordMasuk);
        namadaftar = findViewById(R.id.namaPengguna);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MasukActivity.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEmail = emaildaftar.getText().toString();
                String newPass = passdaftar.getText().toString();
                String newName = namadaftar.getText().toString();

                ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
                Call<Register> call = methods.registerResponse(newName,newEmail,newPass);

                call.enqueue(new Callback<Register>() {
                    @Override
                    public void onResponse(Call<Register> call, Response<Register> response) {
                        if (response.code() == 201) {

                            Log.e("Test", "onResponse: code: " + response.code());

                            Toast.makeText(Daftar.this, "Berhasil daftar", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), MasukActivity.class));
                        } else if (response.code() != 201) {
                            Toast.makeText(Daftar.this, "Bodoh", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Register> call, Throwable t) {

                        Log.e("test", "onFailure" + t.getMessage());
                    }
                });
            }
        });
    }
}