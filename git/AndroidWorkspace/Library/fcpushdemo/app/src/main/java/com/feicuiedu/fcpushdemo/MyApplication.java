package com.feicuiedu.fcpushdemo;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by feicui on 16-12-13.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
