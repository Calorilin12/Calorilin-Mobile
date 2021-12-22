package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.tentangkami.TentangkamiItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TentangKami extends AppCompatActivity {

    TextView isi,judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_kami);
        judul = findViewById(R.id.judulpenggunaanaplikasi);
        isi = findViewById(R.id.isitentangkami);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<TentangkamiItem> call2 = methods2.tentangkamiResponse("Bearer " + token);

        call2.enqueue(new Callback<TentangkamiItem>() {
            @Override
            public void onResponse(Call<TentangkamiItem> call2, Response<TentangkamiItem> response) {
                if (response.isSuccessful()) {
                    System.out.println("TEst");
                    judul.setText(response.body().getJudul());
                    isi.setText(response.body().getTentangKami());

                } else if (response.code() == 500) {

                }
            }

            @Override
            public void onFailure(Call<TentangkamiItem> call2, Throwable t) {

            }
        });
    }
}