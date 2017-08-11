package com.mredrock.freshmanspecial.data;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class RequirementTitle {
    String title ;
    ArrayList <RequirementContent> content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<RequirementContent> getContent() {
        return content;
    }

    public void setContent(ArrayList<RequirementContent> content) {
        this.content = content;
    }

    public class RequirementContent{
        String title;
        String content;

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
    }
}
