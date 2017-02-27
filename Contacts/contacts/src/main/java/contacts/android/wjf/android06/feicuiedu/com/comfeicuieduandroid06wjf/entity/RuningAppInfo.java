package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by ad06-wjf on 2016/11/9.
 */

public class RuningAppInfo {

    private String packageName; //安装包包名
    private Drawable icon;//图标
    private String lableName;//系统包包名
    private long size;//应用大小
    private boolean isClear;//是否需要清除
    private boolean isSystem;//是否是系统应用
    public RuningAppInfo(String packageName, Drawable icon, String lableName,
                         long size) {
        this.packageName = packageName;
        this.icon = icon;
        this.lableName = lableName;
        this.size = size;
        isClear = false;
        isSystem = false;
    }

}
