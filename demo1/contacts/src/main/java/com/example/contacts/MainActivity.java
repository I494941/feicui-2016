package com.example.contacts;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listClass;

    private List<ClassInfo> listData = null;

    private ViewAdapter va = new ViewAdapter<ClassInfo>() {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = lif.inflate(R.layout.class_item_layout, null);
            TextView tvName = (TextView) view.findViewById(R.id.tv_class_name);
            tvName.setText(getItem(position).getName());
            return view;
        }
    };

    private AdapterView.OnItemClickListener ocl = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "你点击的分类的idx是" + listData.get(position).getIdx(), Toast.LENGTH_LONG).show();

            Long idx = listData.get(position).getIdx();

            Intent intent = new Intent();
            intent.putExtra("idx", idx);

            intent.setClass(MainActivity.this, DetailActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    private List<ClassInfo> getData() {

        SQLiteDabseHandle handle = new SQLiteDabseHandle(this);
        SQLiteDatabase database = handle.getSQLite();

        StringBuilder sbSql = new StringBuilder();
        sbSql.append("  select        ");
        sbSql.append("      idx, name ");
        sbSql.append("  from          ");
        sbSql.append("      classlist ");

        Cursor cursor = database.rawQuery(sbSql.toString(), null);

        List<ClassInfo> result = new ArrayList<ClassInfo>();
        while (cursor.moveToNext()) {
            Long idx = cursor.getLong(0);
            String name = cursor.getString(1);

            ClassInfo classInfo = new ClassInfo(idx, name);
            result.add(classInfo);
        }
        return result;
    }


}

