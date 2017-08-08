package com.mredrock.freshmanspecial.httptools;

/**
 * Created by 700-15isk on 2017/8/7.
 */

public class ApiException extends RuntimeException {
    public static final int NO_FOUND =404;
 

    public ApiException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }


    private static String getApiExceptionMessage(int code){
        String message = "";
        switch (code) {
            case 404:
                message = "NO FOUND ";
                break;

            default:
                message = "未知错误";

        }
        return message;
    }
}
