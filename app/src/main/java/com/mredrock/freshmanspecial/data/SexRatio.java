package com.mredrock.freshmanspecial.data;

/**
 * Created by 700-15isk on 2017/8/8.
 */

public class SexRatio {
    private float MenRatio;
    private float WomenRatio;
    private String college;

    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public float getWomenRatio() {

        return WomenRatio;
    }

    public void setWomenRatio(float womenRatio) {
        WomenRatio = womenRatio;
    }

    public float getMenRatio() {
        return MenRatio;
    }
    public void setMenRatio(float menRatio) {
        MenRatio = menRatio;
    }
}
