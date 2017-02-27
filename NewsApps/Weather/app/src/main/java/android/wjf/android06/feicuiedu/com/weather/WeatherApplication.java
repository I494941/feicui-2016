package android.wjf.android06.feicuiedu.com.weather;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.xutils.x;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

public class WeatherApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

        Fresco.initialize(this); // 初始化Fresco
    }
}
