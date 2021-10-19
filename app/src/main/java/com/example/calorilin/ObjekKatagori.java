package com.example.calorilin;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ObjekKatagori {

    int gambar;
    String namakat;

    ObjekKatagori(int gambar, String namakat){
        this.gambar = gambar;
        this.namakat = namakat;
    }

    public int getGambar() {
        return gambar;
    }

    public String getNamakat() {
        return namakat;
    }
}
