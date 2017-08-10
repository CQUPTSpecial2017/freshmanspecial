package com.mredrock.freshmanspecial.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/8 0008.
 */

public class ExcellentTeacher implements Serializable{
    private String name;
    private String information;
    private String avatarUrl;
    private String major;


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public ExcellentTeacher() {
    }

    public ExcellentTeacher(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public ExcellentTeacher(String name, String major,String information, String avatarUrl) {
        this.major = major;
        this.name = name;
        this.information = information;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
