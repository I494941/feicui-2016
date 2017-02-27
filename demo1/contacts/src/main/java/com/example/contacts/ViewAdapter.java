package com.example.contacts;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/10/24.
 */

public abstract class ViewAdapter<T> extends BaseAdapter {

    private List<T> listData = new ArrayList<T>();

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }

    public ViewAdapter() {
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public T getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
