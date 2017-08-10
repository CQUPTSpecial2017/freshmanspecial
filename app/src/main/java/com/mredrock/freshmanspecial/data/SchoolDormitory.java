package com.mredrock.freshmanspecial.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
        //校园宿舍
public class SchoolDormitory implements Serializable{
    private String imageUrl;
    private String title;
    private String content;
    private String imageCount;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageCount() {
        return imageCount;
    }

    public void setImageCount(String imageCount) {
        this.imageCount = imageCount;
    }

    public SchoolDormitory(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }

    public SchoolDormitory(String imageUrl, String title, String content, String imageCount) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.imageCount = imageCount;
    }
}
