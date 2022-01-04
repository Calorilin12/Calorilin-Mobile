package com.calorilin.calorilin_mobile;

public class FlagOpening {
    static Boolean openingBeranda = true;
    static Boolean openingKontrol = true;

    public static Boolean getOpeningKontrol() {
        return openingKontrol;
    }

    public static void setOpeningKontrol(Boolean openingKontrol) {
        FlagOpening.openingKontrol = openingKontrol;
    }

    public static Boolean getOpeningBeranda() {
        return openingBeranda;
    }

    public static void setOpeningBeranda(Boolean openingBeranda) {
        FlagOpening.openingBeranda = openingBeranda;
    }
}
