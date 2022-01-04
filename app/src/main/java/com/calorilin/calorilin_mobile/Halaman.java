package com.calorilin.calorilin_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Halaman extends AppCompatActivity {

    BottomNavigationView bottomnavigasi;
    FlagFragment flagFragment = new FlagFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman);
        bottomnavigasi = findViewById(R.id.bottomnavigasi);

        if (!flagFragment.cekFragment) {
            bukafragment(new FragmentBeranda());
        } else {
            if (flagFragment.fragment2) {
                bukafragment(new FragmentHitungKalori());
                flagFragment.setCekFragment(false);
                flagFragment.setFragment2(false);
                bottomnavigasi.setSelectedItemId(R.id.hitung);
            }
            if (flagFragment.fragment3) {
                bukafragment(new FragmentKontrolKalori());
                flagFragment.setCekFragment(false);
                flagFragment.setFragment3(false);
                bottomnavigasi.setSelectedItemId(R.id.jadwal);
            }
        }

        bottomnavigasi.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.beranda) {
                bukafragment(new FragmentBeranda());
                return true;
            }
            if (item.getItemId() == R.id.profil) {
                bukafragment(new FragmentProfileAkun());
                return true;
            }
            if (item.getItemId() == R.id.jadwal) {
                bukafragment(new FragmentKontrolKalori());
                return true;
            }
            if (item.getItemId() == R.id.hitung) {
                bukafragment(new FragmentHitungKalori());
                return true;
            }
            return false;
        });
    }

    Boolean bukafragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.konten, fragment).commit();
            return true;
        }
        return false;
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        Intent halaman = new Intent(getApplicationContext(), Halaman.class);
        super.onActivityResult(requestCode, resultCode, halaman);

        startActivity(new Intent(getApplicationContext(), Halaman.class));
    }
}