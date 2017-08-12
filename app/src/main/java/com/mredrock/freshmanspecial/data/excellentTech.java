package com.mredrock.freshmanspecial.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
    //优秀老师
public class ExcellentTech implements Serializable{

    /**
     * name : 彭语良
     * url : http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/cyfc_yxjs/9.彭语良.jpg
     */

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
