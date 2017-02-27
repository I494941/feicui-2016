package android.wjf.android06.feicuiedu.com.housekeeper.biz;

/**
 * Created by ad06-wjf on 2016/11/16.
 */

import android.os.Build;

/**
 * 系统信息监测器 (未使用)
 */
public class SystemManager {

    public static String getPhoneName() {
        return Build.BRAND;
    }

    public static String getPhoneModelName() {
// 带国家用 PRODUCT
        return Build.MODEL + " Android" + getPhoneSystemVersion();
    }

}
