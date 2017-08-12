package com.mredrock.freshmanspecial.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
        //校园宿舍
public class Dormitory implements Serializable{

    /**
     * name : 明理苑（24—31,39）
     * resume : 位于千喜鹤食堂正街上，可以俯瞰全校以及南山的部分美丽景色，这里也是重邮夏天最凉爽的地方。可以坐私家车直达寝室，周围有两个超市和上铺，并且校车穿过，每个寝室都为6人间，并设有独立卫生间，每一栋楼里面配置有洗衣机可供大家使用，应有尽有，可以尽情满足同学们的平日生活需求。
     * url : ["http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (1).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (2).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (3).JPG","http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsqs/明理苑 (4).JPG"]
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
