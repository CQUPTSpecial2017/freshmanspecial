package com.mredrock.freshmanspecial.data;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
//学生组织都用这一个

public class StudentOrganization {
    /**
     * name : 重庆邮电大学团委各部室
     * resume :
     * department : [{"name":"团委办公室","resume":"负责协调和承办团委的日常事务；负责团委大型会议的会务工作；团委相关工作的上传与下达；负责奖状、文件的保管工作；协助管理团委资产。"},{"name":"团委组织部","resume":"负责团的基层组织建设工作；开展推优入党工作；负责开展青年马克思主义者培养工程； 指导主题团日活动的开展；开展五四评优表彰工作。"},{"name":"团委宣传部","resume":"负责团属刊物的制作；负责团委官方微博、微信等新媒体阵地的建设；负责myouth平台的建设管理；负责校内各项活动的采访、拍摄及相关专题视频的制作。"}]
     */

    private String name;
    private String resume;
    private List<DepartmentBean> department;

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

    public List<DepartmentBean> getDepartment() {
        return department;
    }

    public void setDepartment(List<DepartmentBean> department) {
        this.department = department;
    }

    public static class DepartmentBean {
        /**
         * name : 团委办公室
         * resume : 负责协调和承办团委的日常事务；负责团委大型会议的会务工作；团委相关工作的上传与下达；负责奖状、文件的保管工作；协助管理团委资产。
         */

        private String name;
        private String resume;

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
    }
}
