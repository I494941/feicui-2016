package android.wjf.android06.feicuiedu.com.xutilsuploaddemo;

import android.app.Application;

import org.xutils.x;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

public class UploadApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
