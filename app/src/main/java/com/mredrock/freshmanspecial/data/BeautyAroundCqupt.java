package com.mredrock.freshmanspecial.data;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
        //周边美景
public class BeautyAroundCqupt {

    /**
     * name : 大金鹰
     * location :  重庆市南岸区南山路25路大金鹰园内
     * resume : 数十里景物尽收眼底
     * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbmj/大金鹰.jpg"]
     */

    private String name;
    private String location;
    private String resume;
    private List<String> url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}
