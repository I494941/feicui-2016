package android.wjf.android06.feicuiedu.com.test.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by ad06-wjf on 2016/11/28.
 */

public class PhoneInfo {

    private String title;
    private String text;
    private Drawable icon;

    public PhoneInfo() {
        super();
    }

    public PhoneInfo(String title, String text, Drawable icon) {
        super();
        this.title = title;
        this.text = text;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}