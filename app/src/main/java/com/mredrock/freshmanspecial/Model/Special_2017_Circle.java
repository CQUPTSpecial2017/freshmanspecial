package com.mredrock.freshmanspecial.Model;

/**
 * Created by Administrator on 2017/8/4 0004.
 */

public class Special_2017_Circle {
    private float radius;
    private int percent;
    private String contentColor;
    private String color;
    private String lastContentColor;
    private String lastColor;

    public String getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
    }

    private String shadowColor ;

    public Special_2017_Circle(float radius, int percent, String contentColor, String color, String lastContentColor, String lastColor,String shadowColor) {
        this.radius = radius;
        this.percent = percent;
        this.contentColor = contentColor;
        this.color = color;
        this.lastContentColor = lastContentColor;
        this.lastColor = lastColor;
        this.shadowColor = shadowColor;
    }



    public String getLastContentColor() {
        return lastContentColor;
    }

    public void setLastContentColor(String lastContentColor) {
        this.lastContentColor = lastContentColor;
    }

    public String getLastColor() {
        return lastColor;
    }

    public void setLastColor(String lastColor) {
        this.lastColor = lastColor;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getContentColor() {
        return contentColor;
    }

    public void setContentColor(String contentColor) {
        this.contentColor = contentColor;
    }

    public Special_2017_Circle(float radius, int percent, String contentColor, String color) {
        this.radius = radius;
        this.percent = percent;
        this.contentColor = contentColor;
        this.color = color;
    }

    public Special_2017_Circle() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
