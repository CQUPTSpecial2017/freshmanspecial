package com.mredrock.freshmanspecial.data;

/**
 * Created by 700-15isk on 2017/8/8.
 */
        //qq群号
public class QQGroupNumber {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public class QQNumber{
        private String GroupName;
        private String Number;

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String groupName) {
            GroupName = groupName;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String number) {
            Number = number;
        }
    }
}
