package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.penggunaanapk.PenggunaanAppItem;
import com.calorilin.calorilin_mobile.model.user.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PenggunaanAplikasi extends AppCompatActivity {

    TextView isipenggunaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penggunaan_aplikasi);

        isipenggunaan = findViewById(R.id.isipenggunaan);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<PenggunaanAppItem> call2 = methods2.penggunaanappResponse("Bearer " + token);

        call2.enqueue(new Callback<PenggunaanAppItem>() {
            @Override
            public void onResponse(Call<PenggunaanAppItem> call2, Response<PenggunaanAppItem> response) {
                if (response.code()<300) {
                    System.out.println("TTTTTTTTTTTT MARIO ANJING");
                    isipenggunaan.setText(response.body().getPenggunaanAplikasi());
                } else if (response.code() == 500) {

                }
            }

            @Override
            public void onFailure(Call<PenggunaanAppItem> call2, Throwable t) {

            }
        });
    }
}