package com.example.calorilin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Halaman extends AppCompatActivity {

    BottomNavigationView bottomnavigasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman);
        bottomnavigasi = findViewById(R.id.bottomnavigasi);
        bukafragment(new FragmentBeranda());
        bottomnavigasi.setOnItemSelectedListener(item -> {
            if(item.getItemId()==R.id.beranda){
                bukafragment(new FragmentBeranda());
                return true;
            }
            if(item.getItemId()==R.id.profil){
                bukafragment(new FragmentProfileAkun());
                return true;
            }
            return true;
        });
    }

    Boolean bukafragment(Fragment fragment)
    {
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.konten, fragment).commit();
            return true;
        }
        return false;
    }
}