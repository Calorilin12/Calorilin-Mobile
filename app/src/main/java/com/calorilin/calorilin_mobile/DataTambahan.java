package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.dailyhealthy.Data;
import com.calorilin.calorilin_mobile.model.user.UserData;
import com.calorilin.calorilin_mobile.model.userdetailspost.UserDetailPost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataTambahan extends AppCompatActivity {

    Button kolesterollabel, diabeteslabel, hipertensilabel, asamuratlabel, asamlambunglabel, simpantambahan;
    static boolean kolesterol = false, diabetes = false, hipertensi = false, asamurat = false, asamlambung = false;
    EditText editberatbadan, edittinggibadan, edittensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_tambahan);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id", "");

        simpantambahan = findViewById(R.id.simpantambahan);
        editberatbadan = findViewById(R.id.editberatbadan);
        edittinggibadan = findViewById(R.id.edittinggibadan);
        edittensi = findViewById(R.id.edittensi);

        kolesterollabel = findViewById(R.id.kolesterollabel);
        kolesterollabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = kolesterollabel.getBackground();

            @Override
            public void onClick(View view) {

                if (!kolesterol) {
                    kolesterollabel.setBackgroundResource(R.drawable.shapehijau);
                    kolesterollabel.setTextColor(Color.WHITE);
                    kolesterol = true;
                } else {
                    kolesterollabel.setBackground(background);
                    kolesterollabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    kolesterol = false;
                }
            }
        });
        diabeteslabel = findViewById(R.id.diabeteslabel);
        diabeteslabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = diabeteslabel.getBackground();

            @Override
            public void onClick(View view) {
                if (!diabetes) {
                    diabeteslabel.setBackgroundResource(R.drawable.shapehijau);
                    diabeteslabel.setTextColor(Color.WHITE);
                    diabetes = true;
                } else {
                    diabeteslabel.setBackground(background);
                    diabeteslabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    diabetes = false;
                }
            }
        });

        hipertensilabel = findViewById(R.id.hipertensilabel);
        hipertensilabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = hipertensilabel.getBackground();

            @Override
            public void onClick(View view) {
                if (!hipertensi) {
                    hipertensilabel.setBackgroundResource(R.drawable.shapehijau);
                    hipertensilabel.setTextColor(Color.WHITE);
                    hipertensi = true;
                } else {
                    hipertensilabel.setBackground(background);
                    hipertensilabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    hipertensi = false;
                }
            }
        });

        asamuratlabel = findViewById(R.id.asamuratlabel);
        asamuratlabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = asamuratlabel.getBackground();

            @Override
            public void onClick(View view) {
                if (!asamurat) {
                    asamuratlabel.setBackgroundResource(R.drawable.shapehijau);
                    asamuratlabel.setTextColor(Color.WHITE);
                    asamurat = true;
                } else {
                    asamuratlabel.setBackground(background);
                    asamuratlabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    asamurat = false;
                }
            }
        });

        asamlambunglabel = findViewById(R.id.asamlambunglabel);
        asamlambunglabel.setOnClickListener(new View.OnClickListener() {
            Drawable background = asamlambunglabel.getBackground();

            @Override
            public void onClick(View view) {
                if (!asamlambung) {
                    asamlambunglabel.setBackgroundResource(R.drawable.shapehijau);
                    asamlambunglabel.setTextColor(Color.WHITE);
                    asamlambung = true;
                } else {
                    asamlambunglabel.setBackground(background);
                    asamlambunglabel.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.abutua));
                    asamlambung = false;
                }
            }
        });

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<UserData> call2 = methods2.userResponse("Bearer " + token, id);

        call2.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call2, Response<UserData> response) {
                if (response.isSuccessful()) {
                    editberatbadan.setHint(String.valueOf(response.body().getWeight()) + " Kg");
                    edittinggibadan.setHint(String.valueOf(response.body().getHeight()) +" Cm");
                    edittensi.setHint(response.body().getTension());

                    if (response.body().getHyperTension() == 1) {
                        hipertensilabel.setBackgroundResource(R.drawable.shapehijau);
                        hipertensilabel.setTextColor(Color.WHITE);
                        hipertensi = true;
                    }
                    if (response.body().getCholesterol() == 1) {
                        kolesterollabel.setBackgroundResource(R.drawable.shapehijau);
                        kolesterollabel.setTextColor(Color.WHITE);
                        kolesterol = true;
                    }
                    if (response.body().getDiabetes() == 1) {
                        diabeteslabel.setBackgroundResource(R.drawable.shapehijau);
                        diabeteslabel.setTextColor(Color.WHITE);
                        diabetes = true;
                    }

                    if (response.body().getUricAcid() == 1) {
                        asamuratlabel.setBackgroundResource(R.drawable.shapehijau);
                        asamuratlabel.setTextColor(Color.WHITE);
                        asamurat = true;
                    }
                    if (response.body().getStomachAcid() == 1) {
                        asamlambunglabel.setBackgroundResource(R.drawable.shapehijau);
                        asamlambunglabel.setTextColor(Color.WHITE);
                        asamlambung = true;
                    }

                } else if (response.code() == 500) {

                }
            }

            @Override
            public void onFailure(Call<UserData> call2, Throwable t) {

            }
        });


        simpantambahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edittinggibadan.getText().toString().length() == 0 || editberatbadan.getText().toString().length() == 0 || edittensi.getText().toString().length() == 0) {
                    Toast.makeText(DataTambahan.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else {
                    int tinggibadan = Integer.valueOf(edittinggibadan.getText().toString());
                    int beratbadan = Integer.valueOf(editberatbadan.getText().toString());
                    String tensi = edittensi.getText().toString();

                    ApiInterface methods = ApiClient.getClient().create(ApiInterface.class);
                    Call<UserDetailPost> call = methods.editdetailResponse("Bearer " + token, id, beratbadan, tinggibadan, tensi, ubahBoolean(kolesterol)
                            , ubahBoolean(diabetes), ubahBoolean(hipertensi), ubahBoolean(asamurat), ubahBoolean(asamlambung));
                    call.enqueue(new Callback<UserDetailPost>() {
                        @Override
                        public void onResponse(Call<UserDetailPost> call, Response<UserDetailPost> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(DataTambahan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            } else if (response.code() == 500) {

                            }
                        }

                        @Override
                        public void onFailure(Call<UserDetailPost> call, Throwable t) {
                            Toast.makeText(DataTambahan.this, "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    public int ubahBoolean(boolean penyakit) {
        int check;
        if (penyakit) {
            check = 1;
        } else {
            check = 0;
        }
        return check;
    }
}