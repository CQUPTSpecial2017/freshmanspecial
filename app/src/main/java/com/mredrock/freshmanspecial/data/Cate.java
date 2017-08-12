package com.mredrock.freshmanspecial.data;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
    //周边美食
public class Cate {

    /**
     * name : 李记串串
     * location : 永辉超市旁边
     * resume : 口味独特，麻辣鲜香
     * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_zbms/李记串串.jpg"]
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
