package com.mredrock.freshmanspecial.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
        //校园环境
public class SchoolEnvironment implements Serializable {
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

    public SchoolEnvironment(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }

}
