package com.mredrock.freshmanspecial.data;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class BeautyInCqupt {
    private String imageUrl;
    private String title;

    private String content;
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

    public BeautyInCqupt(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }
}
