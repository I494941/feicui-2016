package com.feicuiedu.android.appxlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.limxing.xlistview.view.XListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XListView listView;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
        listView = (XListView) findViewById(R.id.lv1);

        listView.setXListViewListener(listViewListener);
        listView.setPullRefreshEnable(true);
        listView.setPullLoadEnable(true);

        listView.setAdapter(ba);
    }

    private List<String> getData() {

        list = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            list.add("item");
        }
        return list;
    }

    /**
     * 下拉数据处理
     *
     * @return
     */
    private List<String> getXiaLaData() {

        List<String> downList = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            downList.add("下拉增加的数据");
        }
        downList.addAll(list);

        if (downList.size() >10) {

            downList = downList.subList(0, 9);

        }

        return downList;
    }

    /**
     * 上推数据处理
     *
     * @return
     */
    private List<String> getShangTuiData() {

        List<String> upList = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            upList.add("上推增加的数据");
        }
        list.addAll(upList);

        if (list.size() >10) {

            list = list.subList(list.size()-10, list.size()-1);

        }
        return list;
    }

    private static class ViewHolder {
        TextView tv;
    }

    private BaseAdapter ba = new BaseAdapter() {
        ViewHolder vh = null;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main_item, null);

                vh = new ViewHolder();
                vh.tv = (TextView) convertView.findViewById(R.id.item_tv1);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            vh.tv.setText(getItemId(position) + ":" + getItem(position));

            return convertView;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return list.get(position);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }
    };

    private XListView.IXListViewListener listViewListener = new XListView.IXListViewListener() {

        // 下拉方法
        @Override
        public void onRefresh() {
            // 加载数据。。。。。。。。。。。。。。。。。。。
            Log.d("refresh", "11111111111111111");
            list = getXiaLaData();
            ba.notifyDataSetChanged();
            // 加载完毕
            listView.stopLoadMore();
            listView.stopRefresh();
            listView.setRefreshTime(getSystime());
        }

        // 上推方法
        @Override
        public void onLoadMore() {
            // 加载数据。。。。。。。。。。。。。。。。。。。
            Log.d("onLoadMore", "2222222222222");
            list = getShangTuiData();
            ba.notifyDataSetChanged();
            listView.stopLoadMore();
            listView.stopRefresh();
        }
    };

    private String getSystime() {
        String systime;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        systime = dateFormat.format(new Date(System.currentTimeMillis()));
        return systime;
    }
}

