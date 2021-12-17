package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id","");

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<Data> call2 = methods2.healthyResponse("Bearer " + token, id);

        call2.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call2, Response<Data> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ProgramHarian.this, "berhasil", Toast.LENGTH_SHORT).show();
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
    }
}