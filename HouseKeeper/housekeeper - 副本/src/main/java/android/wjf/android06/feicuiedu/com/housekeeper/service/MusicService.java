package android.wjf.android06.feicuiedu.com.housekeeper.service;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * 背景音乐服务
 */
public class MusicService extends Service {
    //背景音乐播放器
    MediaPlayer mediaPlayer;

    /**
     * 设置音乐
     */
    public int onStartCommand(Intent intent, int flags, int startId) {
        AssetManager assetManager = getAssets();
        //用于获取Asset文件夹下的资源文件
        try {
            AssetFileDescriptor fileDescriptor = assetManager.openFd("mo.mp3");//加载音乐资源
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getLength());
            mediaPlayer.prepare();//准备音乐
            mediaPlayer.start();//播放音乐
        } catch (IOException e) { // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 停止音乐
     */
    public void onDestroy() {
        mediaPlayer.stop();//停止音乐
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
