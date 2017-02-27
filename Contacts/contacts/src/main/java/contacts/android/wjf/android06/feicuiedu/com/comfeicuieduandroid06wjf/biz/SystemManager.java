package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.biz;

import android.os.Build;

/**
 * Created by ad06-wjf on 2016/11/9.
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
