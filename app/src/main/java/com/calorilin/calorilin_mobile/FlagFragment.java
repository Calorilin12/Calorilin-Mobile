package com.calorilin.calorilin_mobile;

public class FlagFragment {
    static public boolean cekFragment = false;
    static public boolean fragment2 = false;
    static public boolean fragment3 = false;

    public static boolean isCekFragment() {
        return cekFragment;
    }

    public static void setCekFragment(boolean cekFragment) {
        FlagFragment.cekFragment = cekFragment;
    }

    public static boolean isFragment2() {
        return fragment2;
    }

    public static void setFragment2(boolean fragment2) {
        FlagFragment.fragment2 = fragment2;
    }

    public static boolean isFragment3() {
        return fragment3;
    }

    public static void setFragment3(boolean fragment3) {
        FlagFragment.fragment3 = fragment3;
    }
}
