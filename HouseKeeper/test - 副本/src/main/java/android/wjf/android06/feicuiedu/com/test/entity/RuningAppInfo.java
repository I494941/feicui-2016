package android.wjf.android06.feicuiedu.com.test.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by ad06-wjf on 2016/11/16.
 */

public class RuningAppInfo {

    private String packageName; //安装包包名
    private Drawable icon;//图标
    private String lableName;//系统包包名
    private long size;//应用大小
    private boolean isClear;//是否需要清除
    private boolean isSystem;//是否是系统应用

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getLableName() {
        return lableName;
    }

    public void setLableName(String lableName) {
        this.lableName = lableName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean clear) {
        isClear = clear;
    }

    public boolean isSystem() {
        return isSystem;
    }

    public void setSystem(boolean system) {
        isSystem = system;
    }

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
