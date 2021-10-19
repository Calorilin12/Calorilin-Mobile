package com.example.calorilin;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ObjekResepHari {

    int gambar;
    String namaresep,level,waktu,resto;

    public ObjekResepHari(int gambar, String namaresep, String resto, String level, String waktu) {
        this.gambar = gambar;
        this.resto = resto;
        this.namaresep = namaresep;
        this.level = level;
        this.waktu = waktu;
    }

    public int getGambar() {
        return gambar;
    }

    public String getNamaresep() {
        return namaresep;
    }

    public String getResto() {
        return resto;
    }

    public String getLevel() {
        return level;
    }

    public String getWaktu() {
        return waktu;
    }
}
