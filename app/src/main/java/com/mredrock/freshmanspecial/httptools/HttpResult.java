package com.mredrock.freshmanspecial.httptools;

/**
 * Created by 700-15isk on 2017/8/7.
 */

public class HttpResult<T> {
    private int Status;
    private String Info;
    private String Version;
    private T Data;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Info=" + Info + " Status=" + Status + " Version" + Version);
        if (null != Data) {
            sb.append(" subjects:" +Data.toString());
        }
        return sb.toString();
    }



    public String getVersion() {

        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getInfo() {

        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getStatus() {

        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public T getData() {
        return Data;
    }

    public void setData(T requestData) {
       Data= requestData;
    }
}
