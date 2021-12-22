package com.calorilin.calorilin_mobile;

public class DataMinum {
    static int banyakMinum=0;

    public static int getBanyakMinum() {
        return banyakMinum;
    }

    public static void setBanyakMinum(int banyakMinum) {
        DataMinum.banyakMinum = banyakMinum;
    }

    public static void tambahBanyakMinum(){
        DataMinum.banyakMinum = DataMinum.banyakMinum+1;
    }
    public static void kurangBanyakMinum(){
        DataMinum.banyakMinum = DataMinum.banyakMinum-1;
    }
}
