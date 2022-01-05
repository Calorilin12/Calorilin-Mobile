package com.calorilin.calorilin_mobile;

public class FlagGoneKontrol {
    static boolean gonePagi = true;
    static boolean goneSiang = true;
    static boolean goneMalam = true;

    public static boolean isGonePagi() {
        return gonePagi;
    }

    public static void setGonePagi(boolean gonePagi) {
        FlagGoneKontrol.gonePagi = gonePagi;
    }

    public static boolean isGoneSiang() {
        return goneSiang;
    }

    public static void setGoneSiang(boolean goneSiang) {
        FlagGoneKontrol.goneSiang = goneSiang;
    }

    public static boolean isGoneMalam() {
        return goneMalam;
    }

    public static void setGoneMalam(boolean goneMalam) {
        FlagGoneKontrol.goneMalam = goneMalam;
    }
}
