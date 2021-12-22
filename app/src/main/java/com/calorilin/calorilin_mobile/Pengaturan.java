package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.user.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pengaturan extends AppCompatActivity {

    Button editakun;
    TextView halouser,tentangkami,penggunaan;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        back = findViewById(R.id.backpengaturan);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        editakun = findViewById(R.id.akunmenu);
        editakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),EditProfile.class));
            }
        });

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id", "");
        halouser = findViewById(R.id.namapengaturan);

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<UserData> call2 = methods2.userResponse("Bearer " + token, id);

        call2.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call2, Response<UserData> response) {
                if (response.isSuccessful()) {
                    halouser.setText(response.body().getName());
                } else if (response.code() == 500) {

                }
            }

            @Override
            public void onFailure(Call<UserData> call2, Throwable t) {

            }
        });
        tentangkami = findViewById(R.id.tentangkami);
        tentangkami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TentangKami.class));
            }
        });

        penggunaan = findViewById(R.id.penggunaanaplikasi);
        penggunaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PenggunaanAplikasi.class));
            }
        });
    }
}