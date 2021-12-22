package com.calorilin.calorilin_mobile;

public class CheckItem {
    static boolean check = false;

    public CheckItem(boolean check) {
        this.check = check;
    }
    public CheckItem() {

    }

    public static void setCheck(boolean check) {
        CheckItem.check = check;
    }

    public boolean isCheck() {
        return check;
    }
}
