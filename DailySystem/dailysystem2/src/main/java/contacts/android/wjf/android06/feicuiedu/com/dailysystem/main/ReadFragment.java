package contacts.android.wjf.android06.feicuiedu.com.dailysystem.main;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import contacts.android.wjf.android06.feicuiedu.com.dailysystem.main1.DetailActivity;


/**
 * Created by ad06-wjf on 2016/11/24.
 */

public class ReadFragment extends Fragment {


    private Context context;


    private ListView listView;

    private List<DailyInfo> listData = null;

    private DailyHelper dailyHelper;

    private SQLiteDatabase dabase;

    // 布局加载器
    private LayoutInflater lif;

    ViewAdapter va = new ViewAdapter<DailyInfo>() {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder vh = null;

            if (convertView == null) {

                convertView = lif.inflate(R.layout.read_item_layout, null);
                vh = new ViewHolder();
                vh.tvName = (TextView) convertView.findViewById(R.id.tvName);

                vh.tvId = (TextView) convertView.findViewById(R.id.tvId);

                vh.tvDate = (TextView) convertView.findViewById(R.id.tvDate);

                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            vh.tvName.setText(getItem(position).getName());
            vh.tvId.setText(getItem(position).getId().toString());
            vh.tvDate.setText(getItem(position).getCreateDate());

            return convertView;
        }
    };

    private AdapterView.OnItemClickListener ocl = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(context, "你点击的分类的id是" + listData.get(position).getId(), Toast.LENGTH_LONG).show();

            Intent intent = new Intent();

            intent.setClass(context, DetailActivity.class);
            startActivity(intent);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        context = getActivity();
        lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.read_layout, container, false);


        listView = (ListView) view.findViewById(R.id.list_class);

        // 获取显示数据
        listData = getData();

        // 绑定适配器
        va.setListData(listData);



        listView.setAdapter(va);

        // 设置监听
        listView.setOnItemClickListener(ocl);


        return view;
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

    private class ViewHolder {

        TextView tvName;

        TextView tvId;

        TextView tvDate;

    }

}
