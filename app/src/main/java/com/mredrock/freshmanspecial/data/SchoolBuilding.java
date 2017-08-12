package com.mredrock.freshmanspecial.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
        //校园环境
public class SchoolBuilding implements Serializable {


    /**
     * title : 鸟瞰重邮
     * content : 站在腾飞广场，做着属于我们的腾飞梦，从这一刻便开启了你的大学新篇章。秉持“修德、博学、求实、创新”校训，书写你的重邮梦。很高兴能与你在重邮相遇。
     * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xyhj/鸟瞰重邮.png"]
     */

    private String title;
    private String content;
    private List<String> url;

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

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}
