package android.wjf.android06.feicuiedu.com.newsapp.model.entity;

import java.io.Serializable;

/**
 * Created by ad06-wjf on 2016/11/28.
 */

public class News implements Serializable {

    /***
     * 类型标识 1:列表新闻 2：大图新闻
     */
    private int type;
    /**
     * 新闻id
     */
    private int nid;

    /**
     * 时间戳
     */
    private String stamp;
    /**
     * 标题
     */
    private String title = "";
    /**
     * 摘要
     */
    private String summary = "";
    /**
     * 图标
     */
    private String icon = "";
    /**
     * 网页链接
     */
    private String link = "";

    /***
     * 分类
     */
    private int subid;




    public News(int nid, String stamp, String title, String summary, String list_image, String url, int type,int subid) {
        this.nid = nid;
        this.stamp = stamp;
        this.title = title;
        this.summary = summary;
        this.icon = list_image;
        this.link = url;
        this.type = type;
        this.subid = subid;
    }

    public int getNid() {
        return nid;
    }

    public String getStamp() {
        return stamp;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public String getLink() {
        return link;
    }

    public int getType() {
        return type;
    }

    public int getSubid() {
        return subid;
    }

    @Override
    public String toString() {
        return "News [nid=" + nid + ",stamp=" + stamp + ", title=" + title + "," +
                " summary=" + summary + ", icon=" + icon +
                ", url=" + link + ", type=" + type + ", subid=" + subid + "]";
    }

}
