package com.mredrock.freshmanspecial.data;

import java.util.List;

/**
 * Created by 700-15isk on 2017/8/8.
 */

public class FailPlus {
    private String course;
    private String college;
    private List<major> major;
    private float ratio;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public List<major> getMajor() {
        return major;
    }

    public void setMajor(List<major> majors) {
        this.major = majors;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public class major {


        private String major;
        private List<course> course;

        public List<FailPlus.major.course> getCourse() {
            return course;
        }

        public void setCourse(List<FailPlus.major.course> course) {
            this.course = course;
        }


        public String getMajor() {
            return major;
        }


        public void setMajor(String major) {
            this.major = major;
        }

        public class course {
            private String course;
            private float ratio;


            public String getCourse() {
                return course;
            }

            public void setCourse(String course) {
                this.course = course;
            }

            public float getRatio() {
                return ratio;
            }

            public void setRatio(float ratio) {
                this.ratio = ratio;
            }
        }
    }
}
