package com.mredrock.freshmanspecial.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
    //优秀学生
public class ExcellentStudent implements Serializable{
    private String name;
    private String information;
    private String avatarUrl;
    private String says;


    public String getSays(){
        return says;
    }

    public void setSays(String says) {
        this.says = says;
    }

    public ExcellentStudent() {
    }

    public ExcellentStudent(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public ExcellentStudent(String name, String says,String information, String avatarUrl) {
        this.says = says;
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
