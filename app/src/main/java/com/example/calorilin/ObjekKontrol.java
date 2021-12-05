package com.example.calorilin;

public class ObjekKontrol {

    String namamakanan,kontrol1,kontrol2,kontrol3,kalorimakanan;

    public ObjekKontrol(String namamakanan, String kalorimakanan, String kontrol1, String kontrol2, String kontrol3) {
        this.namamakanan = namamakanan;
        this.kalorimakanan = kalorimakanan;
        this.kontrol1 = kontrol1;
        this.kontrol2 = kontrol2;
        this.kontrol3 = kontrol3;
    }

    public String getNamamakanan() {
        return namamakanan;
    }

    public String getKontrol1() {
        return kontrol1;
    }

    public String getKontrol2() {
        return kontrol2;
    }

    public String getKontrol3() {
        return kontrol3;
    }

    public String getKalorimakanan() {
        return kalorimakanan;
    }
}
