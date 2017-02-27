package android.wjf.android06.feicuiedu.com.housekeeper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.housekeeper.R;
import android.wjf.android06.feicuiedu.com.housekeeper.entity.TelclassInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

public class TelclassAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;

    public TelclassAdapter(Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return adapterDatas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.inflate_telmgr_listitem, null);
        }
        TextView tv_text = (TextView) convertView.findViewById(R.id.textview);
        tv_text.setText(getItem(position).name);
        return convertView;
    }

    @Override
    public TelclassInfo getItem(int position) {
        return adapterDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 当前适配器内的数据集合 (当前适配器适配工作只认此集合)
    private ArrayList<TelclassInfo> adapterDatas = new ArrayList<TelclassInfo>();

    // 添加数据到当前适配器集合
    public void addDataToAdapter(TelclassInfo e) {
        if (e != null) {
            adapterDatas.add(e);
        }
    }

    // 添加数据到当前适配器集合
    public void addDataToAdapter(List<TelclassInfo> e) {
        if (e != null) {
            adapterDatas.addAll(e);
        }
    }

    public ArrayList<TelclassInfo> getDataFromAdapter() {
        return adapterDatas;
    }

    //删除当前适配器集合内数据
    public void clearDataTOAdapter() {
        adapterDatas.clear();
    }

}
