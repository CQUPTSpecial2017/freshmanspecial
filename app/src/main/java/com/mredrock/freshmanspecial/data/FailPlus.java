package com.mredrock.freshmanspecial.data;

import java.util.List;

/**
 * Created by 700-15isk on 2017/8/8.
 */

public class FailPlus {

        /**
         * college : 经济管理学院
         * major : [{"major":"工商管理类","course":[{"course":"C语言程序设计","ratio":"0.3556701030927835"},{"course":"高等数学B(下)","ratio":"0.20103092783505155"},{"course":"线性代数B","ratio":"0.15463917525773196"}]},{"major":"工程管理","course":[{"course":"C语言程序设计","ratio":"0.43333333333333335"},{"course":"高等数学B(下)","ratio":"0.3"},{"course":"大学英语","ratio":"0.15"}]},{"major":"信息管理与信息系统","course":[{"course":"计算机网络","ratio":"0.42857142857142855"},{"course":"高等数学B(下)","ratio":"0.22857142857142856"},{"course":"面向对象程序设计","ratio":"0.06666666666666667"}]},{"major":"经济学","course":[{"course":"高等数学B(下)","ratio":"0.4444444444444444"},{"course":"C语言程序设计","ratio":"0.20833333333333334"},{"course":"会计学","ratio":"0.19444444444444445"}]},{"major":"电子商务大类","course":[{"course":"C语言程序设计","ratio":"0.4732142857142857"},{"course":"高等数学B(下)","ratio":"0.22321428571428573"},{"course":"大学英语","ratio":"0.08928571428571429"}]}]
         */
        private String college;
        private List<MajorBean> major;

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public List<MajorBean> getMajor() {
            return major;
        }

        public void setMajor(List<MajorBean> major) {
            this.major = major;
        }

        public static class MajorBean {
            /**
             * major : 工商管理类
             * course : [{"course":"C语言程序设计","ratio":"0.3556701030927835"},{"course":"高等数学B(下)","ratio":"0.20103092783505155"},{"course":"线性代数B","ratio":"0.15463917525773196"}]
             */

            private String major;
            private List<CourseBean> course;

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
            }

            public List<CourseBean> getCourse() {
                return course;
            }

            public void setCourse(List<CourseBean> course) {
                this.course = course;
            }

            public static class CourseBean {
                /**
                 * course : C语言程序设计
                 * ratio : 0.3556701030927835
                 */

                private String course;
                private String ratio;

                public String getCourse() {
                    return course;
                }

                public void setCourse(String course) {
                    this.course = course;
                }

                public String getRatio() {
                    return ratio;
                }

                public void setRatio(String ratio) {
                    this.ratio = ratio;
                }
            }
        }
    }
