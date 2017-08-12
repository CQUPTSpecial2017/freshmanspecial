package com.mredrock.freshmanspecial.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
    //学校食堂
public class SchoolCanteen implements Serializable {

    /**
     * name : 中心食堂
     * resume : 地理位置的优越不仅来源于它历史的悠久，更是因为中心特色小面的支持，这里一砖一瓦都沉淀着岁月的气息。又大又好吃又便宜的素菜包子和肉花卷、馒头加豆浆，是早餐的不二选择。
     * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/中心食堂.jpg"]
     */

    private String name;
    private String resume;
    private List<String> url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
