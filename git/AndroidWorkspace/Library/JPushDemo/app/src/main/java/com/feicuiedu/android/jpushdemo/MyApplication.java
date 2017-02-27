package com.feicuiedu.android.jpushdemo;

import android.app.Application;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * Created by chenyan on 2016/12/13.
 */

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        Set<String> set = new HashSet<>();
        set.add("cy1");
        set.add("cy2");
        JPushInterface.setAliasAndTags(this, "cy", set, new TagAliasCallback() {
            @Override
            public void gotResult(int i, String s, Set<String> set) {
                Log.d(TAG, "gotResult() called with: i = [" + i + "], s = [" + s + "], set = [" + set + "]");
            }
        });
    }
}
