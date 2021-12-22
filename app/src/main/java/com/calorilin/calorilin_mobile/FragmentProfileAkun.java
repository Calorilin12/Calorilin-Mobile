package com.calorilin.calorilin_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.calorilin.calorilin_mobile.api.ApiClient;
import com.calorilin.calorilin_mobile.api.ApiInterface;
import com.calorilin.calorilin_mobile.model.user.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentProfileAkun extends Fragment {

    Button pengaturan,keluar;
    ImageView lengkapidata,fotoprofile;
    TextView namaAkun,bergabung;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profileakun, container, false);

        pengaturan = view.findViewById(R.id.pegaturanprofile);
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Pengaturan.class);
                startActivity(intent);
            }
        });

        lengkapidata = view.findViewById(R.id.lengkapidata);
        lengkapidata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DataTambahan.class);
                startActivity(intent);

            }
        });

        keluar = view.findViewById(R.id.keluar);
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        namaAkun = view.findViewById(R.id.namaAkun);
        fotoprofile = view.findViewById(R.id.fotoprofile);
        bergabung = view.findViewById(R.id.bergabung);

        SharedPreferences sp = getActivity().getApplicationContext().getSharedPreferences("sharepre", Context.MODE_PRIVATE);
        String token = sp.getString("tokens", "");
        String id = sp.getString("id","");

        ApiInterface methods2 = ApiClient.getClient().create(ApiInterface.class);
        Call<UserData> call2 = methods2.userResponse("Bearer " + token, id);

        call2.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call2, Response<UserData> response) {
                if (response.isSuccessful()) {
                    namaAkun.setText(response.body().getName());
                    bergabung.setText(response.body().getPhoneNumber());
                    Glide.with(fotoprofile)
                            .load("https://api.calorilin.me/user-detail-images/"+ response.body().getImage()).circleCrop().into(fotoprofile);
                } else if (response.code() == 500) {

                }
            }

            @Override
            public void onFailure(Call<UserData> call2, Throwable t) {
                Toast.makeText(requireContext(), "Gagal" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
