package contacts.android.wjf.android06.feicuiedu.com.checkboxdemo2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ListView lvData;

    private Context context;

    private CheckBox chkAll;

    private Button btnShow;
    // 布局加载器
    private LayoutInflater lif;

    private List<Map<String, String>> listData;

    private class ViewHolder {
        CheckBox itemChk;
        ImageView itemIv;
        TextView itemTvName;
        TextView itemTvContent;
        TextView itemTvEnd;
    }

    private Map<Integer, Boolean> mapDataSelected = new HashMap<>();

    private View.OnClickListener showOcl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < mapDataSelected.size(); i++) {
                if (mapDataSelected.get(i)) {
                    sb.append(i + " ,");
                }
            }

            if (sb.toString().isEmpty()) {

                Toast.makeText(context, "您没有勾选任意一笔资料", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "您勾选的资料id为:" + sb, Toast.LENGTH_SHORT).show();
            }
        }
    };

    private CompoundButton.OnCheckedChangeListener occl = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            for (int i = 0; i < mapDataSelected.size(); i++) {
                mapDataSelected.put(i, isChecked);
            }

            ba.notifyDataSetChanged();
        }
    };
    private View.OnClickListener ocl = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            CheckBox cb = (CheckBox) view;
            for (int i = 0; i < mapDataSelected.size(); i++) {
                mapDataSelected.put(i, cb.isChecked());
            }

            ba.notifyDataSetChanged();
        }
    };


    private CompoundButton.OnCheckedChangeListener itemOccl = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


            Log.d(TAG, "onCheckedChanged: buttonView.getTag()" + buttonView.getTag());

            String strId = (String) buttonView.getTag();
            Log.d(TAG, "onCheckedChanged: strId" + strId);
            int id = Integer.parseInt(strId.substring(3));
            if (isChecked) {
                mapDataSelected.put(id, isChecked);

            } else {
                mapDataSelected.put(id, !isChecked);
            }
        }
    };


    // 定义并设置数据源
    private BaseAdapter ba = new BaseAdapter() {

        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Map<String, String> getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder vh = null;

            if (convertView == null) {

                convertView = lif.inflate(R.layout.activity_multiple_item, null);
                vh = new ViewHolder();
                vh.itemChk = (CheckBox) convertView.findViewById(R.id.item_chk);
                vh.itemIv = (ImageView) convertView.findViewById(R.id.item_iv);
                vh.itemTvName = (TextView) convertView.findViewById(R.id.item_tv_name);
                vh.itemTvContent = (TextView) convertView.findViewById(R.id.item_tv_content);
                vh.itemTvEnd = (TextView) convertView.findViewById(R.id.item_tv_end);

                convertView.setTag(vh);
            } else {

                vh = (ViewHolder) convertView.getTag();
            }

            vh.itemChk.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;

                    mapDataSelected.put(position, cb.isChecked());

                    int num = 0;
                    for (int i = 0; i < mapDataSelected.size(); i++) {
                        if (mapDataSelected.get(i)) {
                            num++;
                        }
                    }

                    if (num == mapDataSelected.size()) {
                        chkAll.setChecked(true);
                    } else {
                        chkAll.setChecked(false);
                    }
                }
            });


            Map<String, String> tmpMap = getItem(position);
            String id = (String) tmpMap.get("id" + position);
            String name = (String) tmpMap.get("name");
            String content = (String) tmpMap.get("content");
            String end = (String) tmpMap.get("end");

            vh.itemChk.setChecked(mapDataSelected.get(position));


            vh.itemChk.setTag(id);
            vh.itemTvName.setText(name);
            vh.itemTvContent.setText(content);
            vh.itemTvEnd.setText(end);


            return convertView;
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);

        // 初始化布局加载器和上下文引用

        lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        context = this;

        // 控件初始化
        lvData = (ListView) findViewById(R.id.lv_data);
        chkAll = (CheckBox) findViewById(R.id.cb_all);
        btnShow = (Button) findViewById(R.id.btn_show);

        //显示选中的ID
        btnShow.setOnClickListener(showOcl);

        //全选按钮
        // chkAll.setOnCheckedChangeListener(occl);
        chkAll.setOnClickListener(ocl);

        // 初始化数据源
        listData = getData();

        // 控件和数据源绑定
        lvData.setAdapter(ba);

    }

    private List<Map<String, String>> getData() {

        List<Map<String, String>> result = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("id" + i, "key" + i);
            map.put("name", "我是name" + i);
            map.put("content", "我的内容是" + i);
            if (i % 2 == 0) {
                map.put("end", "系统进程");
            } else {
                map.put("end", "用户进程");
            }
            result.add(map);
            mapDataSelected.put(i, false);
        }


        return result;
    }

}
