package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.reportbug.ReportBug;
import com.calorilin.calorilin_mobile.model.userdetailspost.UserDetailPost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Reportbug extends AppCompatActivity {
    EditText reportbug;
    Button simpanbug;
    String isilaporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_bug);
        reportbug = findViewById(R.id.etreportbug);
        simpanbug = findViewById(R.id.simpanbug);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id", "");

        simpanbug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isilaporan = reportbug.getText().toString();

                if (isilaporan.length() == 0){
                    Toast.makeText(Reportbug.this, "Laporan tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
                    Call<ReportBug> call = methods.reportBugResponse(id,"Bearer " + token, isilaporan);
                    call.enqueue(new Callback<ReportBug>() {
                        @Override
                        public void onResponse(Call<ReportBug> call, Response<ReportBug> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(Reportbug.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                finish();
                            } else if (response.code() == 500) {

                            }
                        }

                        @Override
                        public void onFailure(Call<ReportBug> call, Throwable t) {
                            Toast.makeText(Reportbug.this, "Gagal " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}