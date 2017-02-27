package com.example.daily;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginedActivity extends AppCompatActivity {

    private ListView listClass;

    private List<DailyInfo> listData = null;

    private ViewAdapter va = new ViewAdapter<DailyInfo>() {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = lif.inflate(R.layout.logined_item_layout, null);
            TextView tvName = (TextView) view.findViewById(R.id.tvName);
            tvName.setText(getItem(position).getName());
            TextView tvId = (TextView) view.findViewById(R.id.tvId);
            tvId.setText(getItem(position).getId().toString());
            TextView tvDate = (TextView) view.findViewById(R.id.tvDate);
            tvDate.setText(getItem(position).getCreateDate());
            return view;
        }
    };

    private AdapterView.OnItemClickListener ocl = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(LoginedActivity.this, "你点击的分类的id是" + listData.get(position).getId(), Toast.LENGTH_LONG).show();

            Intent intent = new Intent();

            intent.setClass(LoginedActivity.this, DetailActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logined_layout);

        // 获取对象
        listClass = (ListView) findViewById(R.id.list_class);

        // 获取显示数据
        listData = getData();

        // 绑定适配器
        va.setListData(listData);

        listClass.setAdapter(va);

        // 设置监听
        listClass.setOnItemClickListener(ocl);
    }

    private List<DailyInfo> getData() {

        SQLiteDabseHandle handle = new SQLiteDabseHandle(this);
        SQLiteDatabase database = handle.getSQLite();

        StringBuilder sbSql = new StringBuilder();
        sbSql.append("  select        ");
        sbSql.append("      id,name,create_date ");
        sbSql.append("  from          ");
        sbSql.append("      daily ");

        Cursor cursor = database.rawQuery(sbSql.toString(), null);

        List<DailyInfo> result = new ArrayList<DailyInfo>();
        while (cursor.moveToNext()) {
            Long id = cursor.getLong(0);
            String name = cursor.getString(1);
            String createDate = cursor.getString(2);

            DailyInfo dailyInfo = new DailyInfo(id, name,createDate);
            result.add(dailyInfo);
        }
        return result;
    }


}
