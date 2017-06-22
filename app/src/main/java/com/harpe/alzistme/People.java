package com.harpe.alzistme;

import java.util.ArrayList;

/**
 * Created by ARC Team for AugmentEPF project on 22/06/2017.
 */

public class People {

    private String name;
    private String phoneNumber;
    private int resId;
    public static ArrayList<People> peoples;

    static {
        peoples = new ArrayList<>();
        peoples.add(new People("Anthony","0608478544",R.drawable.user));
        peoples.add(new People("Hugo","0760702510",R.drawable.user));
    }


    public People(String name, String phoneNumber, int resId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getResId() {
        return resId;
    }
}
