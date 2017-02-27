package com.example.linechartview;

/**
 * Created by wangjinfei on 16/12/25.
 */

public class BrokenLineCusVisit {
    //拜访日期
    private String date;
    //拜访数量
    private int data;

    public BrokenLineCusVisit(String date, int data) {
        this.date = date;
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}