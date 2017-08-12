package com.mredrock.freshmanspecial.data;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
        //日常生活
public class DailyLife {

    /**
     * name : ZAKKA生活小铺
     * location : 重庆邮电大学旁，新校门出门，左转直走，老校门出门，右转直走
     * resume :
     文具等用品齐全
     * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_rcsh/ZAKKA生活小铺.jpg"]
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
