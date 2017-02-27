package com.example.daily;

/**
 * Created by ad06-wjf on 2016/10/25.
 */

public class UserInfo {

    private Long id;

    private String name;

    private String password;

    private String loginName;

    public UserInfo(String loginName, String password) {
        this.password = password;
        this.loginName = loginName;
    }

    public UserInfo(Long id, String name, String password, String loginName) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.loginName = loginName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
