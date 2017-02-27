package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils;

/**
 * Created by ad06-wjf on 2016/11/3.
 */

import android.util.Log;

/**
 * 日志管理工具类(耦合度高,有改进空间) * *
 */

public class LogUtil {

    public static boolean isOpenDebug = true;
    public static boolean isOpenWarn = true;

    public static void d(String tag, String msg) {
        if (isOpenDebug) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {

        if (isOpenWarn) {
            Log.w(tag, msg);
        }
    }
}
