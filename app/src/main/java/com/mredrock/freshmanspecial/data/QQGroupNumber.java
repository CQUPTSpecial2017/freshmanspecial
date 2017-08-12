package com.mredrock.freshmanspecial.data;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.List;
>>>>>>> 730ace2f12813ec2654bfc1763ac21a9878937ce

/**
 * Created by 700-15isk on 2017/8/8.
 */
        //qq群号
public class QQGroupNumber {

<<<<<<< HEAD
    private ArrayList<String> mNumbers;

    public ArrayList<String> getNumbers() {
        return mNumbers;
    }

    public void setNumbers(ArrayList<String> numbers) {
        mNumbers = numbers;
    }
=======
    private List<HomelandBean> homeland;
    private List<CollegeBean> college;

    public List<HomelandBean> getHomeland() {
        return homeland;
    }

    public void setHomeland(List<HomelandBean> homeland) {
        this.homeland = homeland;
    }

    public List<CollegeBean> getCollege() {
        return college;
    }

    public void setCollege(List<CollegeBean> college) {
        this.college = college;
    }

    public static class HomelandBean {
        /**
         * GroupName : 贵州
         * Number : 601631814
         */

        private String GroupName;
        private String Number;
>>>>>>> 730ace2f12813ec2654bfc1763ac21a9878937ce


<<<<<<< HEAD
=======
        public void setGroupName(String GroupName) {
            this.GroupName = GroupName;
        }
>>>>>>> 730ace2f12813ec2654bfc1763ac21a9878937ce


<<<<<<< HEAD
=======
        public void setNumber(String Number) {
            this.Number = Number;
        }
    }

    public static class CollegeBean {
        /**
         * GroupName : 通信与信息工程学院
         * Number : 498167991
         */

        private String GroupName;
        private String Number;

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String GroupName) {
            this.GroupName = GroupName;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String Number) {
            this.Number = Number;
        }
    }
>>>>>>> 730ace2f12813ec2654bfc1763ac21a9878937ce
}

