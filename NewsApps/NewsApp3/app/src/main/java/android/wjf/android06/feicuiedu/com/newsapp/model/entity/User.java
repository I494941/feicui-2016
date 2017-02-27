package android.wjf.android06.feicuiedu.com.newsapp.model.entity;

/**
 * Created by ad06-wjf on 2016/11/29.
 */

public class User {
    /**
     * 用户id
     */
    private String uid;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户积分
     */
    private int integration;
    /**
     * 评论数量
     */
    private int comnum;
    /**
     * 头像
     */
    private String portrait;
    /**
     * 登陆日志
     */
    //private List<LoginLog> loginlog;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIntegration() {
        return integration;
    }

    public void setIntegration(int integration) {
        this.integration = integration;
    }

    public int getComnum() {
        return comnum;
    }

    public void setComnum(int comnum) {
        this.comnum = comnum;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
