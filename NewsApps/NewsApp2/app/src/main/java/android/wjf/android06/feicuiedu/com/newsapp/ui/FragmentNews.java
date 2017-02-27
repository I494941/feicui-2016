package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.wjf.android06.feicuiedu.com.newsapp.R;
import android.wjf.android06.feicuiedu.com.newsapp.net.NewsRequestNet;
import android.wjf.android06.feicuiedu.com.newsapp.net.RequestNet;
import android.wjf.android06.feicuiedu.com.newsapp.ui.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

public class FragmentNews extends Fragment {

    private Context context;

    //动态加载Button

    private LinearLayout ll;

    private ListView lvMain;

    private LayoutInflater lif;

    private List<Map<String, String>> newsList;
    private Map<String, String> subGroupMap = new LinkedHashMap<>();
    String subid = "";

    NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();
        lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_news, container, false);
        lvMain = (ListView) view.findViewById(R.id.lv_main);
        ll = (LinearLayout) view.findViewById(R.id.view);

        new RequestNet().requestNet(new RequestNet.IResponse() {
            @Override
            public void onReturn(Map<String, String> map) {

                subGroupMap = map;

                for (Map.Entry<String, String> entry : subGroupMap.entrySet()) {
                    subid = entry.getKey();
                    if (subid != null) {
                        break;
                    }
                }
                initButton();
                newsList = new ArrayList<>();
                adapter = new NewsAdapter(newsList, context);
                new NewsRequestNet().rewsRequestNet(subid, newsList, adapter);
                lvMain.setAdapter(adapter);

            }
        });


        return view;
    }

    public void initButton() {

        for (Map.Entry<String, String> entry : subGroupMap.entrySet()) {
            //设置文本的样式
            Button btn = new Button(context.getApplicationContext());
            btn.setText(entry.getValue());
            btn.setId(Integer.parseInt(entry.getKey()));
            btn.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT));
            btn.setOnClickListener(oclBTN);
            //动态添加文本
            ll.addView(btn);
        }
    }

    View.OnClickListener oclBTN = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            subid = String.valueOf(view.getId());
            newsList = new ArrayList<>();
            adapter = new NewsAdapter(newsList, context);
            new NewsRequestNet().rewsRequestNet(subid, newsList, adapter);
            lvMain.setAdapter(adapter);

        }
    };


}

