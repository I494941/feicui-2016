package com.feicuiedu.android.jpushdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by chenyan on 2016/12/13.
 */

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        // SDK 向 JPush Server 注册所得到的注册 全局唯一的 ID ，可以通过此 ID 向对应的客户端发送消息和通知
        String extra_registration_id = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);

        // 保存服务器推送下来的消息的标题 对应 API 消息内容的 title 字段 Portal 推送消息界上不作展示
        String extra_title = bundle.getString(JPushInterface.EXTRA_TITLE);

        // 保存服务器推送下来的消息内容  对应 API 消息内容的 message 字段 对应 Portal 推送消息界面上的"自定义消息内容”字段
        String extra_message = bundle.getString(JPushInterface.EXTRA_MESSAGE);

        // 保存服务器推送下来的附加字段。这是个 JSON 字符串 对应 API 消息内容的 extras 字段 对应 Portal 推送消息界面上的“可选设置”里的附加字段
        String extra_extra = bundle.getString(JPushInterface.EXTRA_EXTRA);

        // 保存服务器推送下来的内容类型 对应 API 消息内容的 content_type 字段
        String extra_content_type = bundle.getString(JPushInterface.EXTRA_CONTENT_TYPE);

        // 富媒体通消息推送下载后的文件路径和文件名
        String extra_richpush_file_path = bundle.getString(JPushInterface.EXTRA_RICHPUSH_FILE_PATH);

        // 唯一标识消息的 ID, 可用于上报统计等
        String extra_msg_id = bundle.getString(JPushInterface.EXTRA_MSG_ID);

        // 保存服务器推送下来的通知的标题 对应 API 通知内容的 title 字段 对应 Portal 推送通知界面上的“通知标题”字段
        String extra_notification_title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);

        // 保存服务器推送下来的通知内容  对应 API 通知内容的 alert 字段 对应 Portal 推送通知界面上的“通知内容”字段
        String extra_alert = bundle.getString(JPushInterface.EXTRA_ALERT);



        Log.d(TAG, "extra_registration_id" + extra_registration_id);
        Log.d(TAG, "extra_title" + extra_title);
        Log.d(TAG, "extra_message" + extra_message);
        Log.d(TAG, "extra_extra" + extra_extra);
        Log.d(TAG, "extra_content_type" + extra_content_type);
        Log.d(TAG, "extra_richpush_file_path" + extra_richpush_file_path);
        Log.d(TAG, "extra_msg_id" + extra_msg_id);
        Log.d(TAG, "extra_notification_title" + extra_notification_title);
        Log.d(TAG, "extra_alert" + extra_alert);

    }
}
