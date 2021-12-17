package com.calorilin.calorilin_mobile;

public class DataPenyakit {
    static int cholesterol,diabetes,hipertensi,asamUrat,asamLambung;

    public DataPenyakit() {
    }

    public DataPenyakit(int cholesterol, int diabetes, int hipertensi, int asamUrat, int asamLambung) {
        DataPenyakit.cholesterol = cholesterol;
        DataPenyakit.diabetes = diabetes;
        DataPenyakit.hipertensi = hipertensi;
        DataPenyakit.asamUrat = asamUrat;
        DataPenyakit.asamLambung = asamLambung;
    }

    public static void setCholesterol(int cholesterol) {
        DataPenyakit.cholesterol = cholesterol;
    }

    public static void setDiabetes(int diabetes) {
        DataPenyakit.diabetes = diabetes;
    }

    public static void setHipertensi(int hipertensi) {
        DataPenyakit.hipertensi = hipertensi;
    }

    public static void setAsamUrat(int asamUrat) {
        DataPenyakit.asamUrat = asamUrat;
    }

    public static void setAsamLambung(int asamLambung) {
        DataPenyakit.asamLambung = asamLambung;
    }
}
