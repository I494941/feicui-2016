package com.feicuiedu.fcpushdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Bundle bundle = intent.getExtras();
        String message = bundle.getString(JPushInterface.EXTRA_ALERT);

        Log.d(TAG, "onReceive: "+message);

    }
}
