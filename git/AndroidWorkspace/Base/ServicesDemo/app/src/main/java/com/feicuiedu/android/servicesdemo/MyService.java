package com.feicuiedu.android.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by feicui on 16-12-7.
 */

public class MyService extends Service {

    private static final String TAG = "MyService";
    
    @Override
    public IBinder onBind(Intent intent) {

        Log.d(TAG, "onBind: ");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
        
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
    
}
