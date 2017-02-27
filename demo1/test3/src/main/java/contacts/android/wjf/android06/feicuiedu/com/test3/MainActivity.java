package contacts.android.wjf.android06.feicuiedu.com.test3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ad06-wjf on 2016/11/7.
 */

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private LayoutInflater lif;

    private List<String> list;


    private BaseAdapter ba = new BaseAdapter() {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public String getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            ViewHolder vh = null;

            if (convertView == null) {

                convertView = lif.inflate(R.layout.item_laypout, null);
                vh = new ViewHolder();
                vh.tv = (TextView) convertView.findViewById(R.id.tv1);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            TextView tv = vh.tv;
            tv.setText(getItem(position));

           /* if (position % 2 == 0) {
                tv.setBackgroundColor(Color.GREEN);
            } else {

                tv.setBackgroundColor(Color.RED);
            }*/


            return convertView;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        listView = (ListView) findViewById(R.id.list_class);
        lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        list = getData();
        listView.setAdapter(ba);

    }

    private List<String> getData() {

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < 200; i++) {
            result.add("这是第" + (i + 1) + "笔资料");
        }

        return result;
    }

    private static class ViewHolder {
        TextView tv;
    }
}
