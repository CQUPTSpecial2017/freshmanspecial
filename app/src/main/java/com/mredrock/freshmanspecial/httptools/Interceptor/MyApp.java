package com.mredrock.freshmanspecial.httptools.interceptor;

import android.app.Application;
import android.content.Context;

/**
 * Created by 700-15isk on 2017/8/12.
 */

public class MyApp extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
}
