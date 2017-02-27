package android.wjf.android06.feicuiedu.com.jpushdemo;


import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by ad06-wjf on 2016/12/14.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
