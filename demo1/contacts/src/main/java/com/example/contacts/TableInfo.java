package com.example.contacts;

/**
 * Created by apple on 16/10/24.
 */

public class TableInfo {

    private Long _id;
    private String number;
    private String name;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TableInfo(Long _id, String number, String name) {

        this._id = _id;
        this.number = number;
        this.name = name;
    }
}
