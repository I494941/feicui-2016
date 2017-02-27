package contacts.android.wjf.android06.feicuiedu.com.dailysystem.main;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import contacts.android.wjf.android06.feicuiedu.com.dailysystem.R;
import contacts.android.wjf.android06.feicuiedu.com.dailysystem.adapter.ViewAdapter;
import contacts.android.wjf.android06.feicuiedu.com.dailysystem.db.DailyHelper;
import contacts.android.wjf.android06.feicuiedu.com.dailysystem.infor.DailyInfo;


/**
 * Created by ad06-wjf on 2016/11/7.
 */

public class ReadActivity extends AppCompatActivity {

    private Context context;
    private ListView listView;
    private LayoutInflater lif;
    private List<DailyInfo> listData = null;

    private DailyHelper dailyHelper;

    private SQLiteDatabase dabase;

    private ViewAdapter va = new ViewAdapter<DailyInfo>() {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = lif.inflate(R.layout.read_item_layout, null);
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
            Toast.makeText(ReadActivity.this, "你点击的分类的id是" + listData.get(position).getId(), Toast.LENGTH_LONG).show();

            Intent intent = new Intent();

            intent.setClass(ReadActivity.this, DetailActivity.class);
            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_layout);

        context = this;
        listView = (ListView) findViewById(R.id.list_class);
        lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 获取显示数据
        listData = getData();

        // 绑定适配器
        va.setListData(listData);

        listView.setAdapter(va);

        // 设置监听
        listView.setOnItemClickListener(ocl);


    }

    private List<DailyInfo> getData() {


        StringBuilder sbSql = new StringBuilder();
        sbSql.append("  select                        ");
        sbSql.append("      d_id,d_name,d_create_date ");
        sbSql.append("  from                          ");
        sbSql.append("      daily_                    ");

        dailyHelper = new DailyHelper(context);
        dabase = dailyHelper.getWritableDatabase();
        Cursor cursor = dabase.rawQuery(sbSql.toString(), null);

        List<DailyInfo> result = new ArrayList<DailyInfo>();


        while (cursor.moveToNext()) {
            Long id = cursor.getLong(0);
            String name = cursor.getString(1);
            String createDate = cursor.getString(2);

            DailyInfo dailyInfo = new DailyInfo(id, name, createDate);
            result.add(dailyInfo);
        }
        return result;
    }

}
