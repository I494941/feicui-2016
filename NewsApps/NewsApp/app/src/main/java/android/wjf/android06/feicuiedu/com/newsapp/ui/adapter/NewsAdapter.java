package android.wjf.android06.feicuiedu.com.newsapp.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.newsapp.R;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ad06-wjf on 2016/12/1.
 */

public class NewsAdapter extends BaseAdapter {

    private List<Map<String, String>> list = new ArrayList<>();
    private Context context;
    private LayoutInflater lif;

    public NewsAdapter(List<Map<String, String>> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Map<String, String> getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder vh = null;

        if (convertView == null) {

            convertView = lif.inflate(R.layout.activity_main_item, null);
            vh = new ViewHolder();
            vh.ivItemIcon = (ImageView) convertView.findViewById(R.id.iv_item_icon);
            vh.tvItemTitle = (TextView) convertView.findViewById(R.id.tv_item_title);
            vh.tvItemSummary = (TextView) convertView.findViewById(R.id.tv_item_summary);
            vh.tvItemStamp = (TextView) convertView.findViewById(R.id.tv_item_stamp);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        x.image().bind(vh.ivItemIcon,list.get(position).get("icon"));
        vh.tvItemTitle.setText(list.get(position).get("title"));
        vh.tvItemSummary.setText(list.get(position).get("summary"));
        vh.tvItemStamp.setText(list.get(position).get("stamp"));

        return convertView;
    }

    private class ViewHolder {

        ImageView ivItemIcon;
        TextView tvItemTitle;
        TextView tvItemSummary;
        TextView tvItemStamp;

    }


}
