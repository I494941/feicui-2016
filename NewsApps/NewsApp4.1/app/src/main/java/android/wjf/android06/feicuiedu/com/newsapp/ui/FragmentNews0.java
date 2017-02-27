package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.wjf.android06.feicuiedu.com.newsapp.R;
import android.wjf.android06.feicuiedu.com.newsapp.model.dao.NewsDBManager;
import android.wjf.android06.feicuiedu.com.newsapp.model.dao.NewsSubTypeDBManager;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.News;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.SubType;
import android.wjf.android06.feicuiedu.com.newsapp.net.Gobal;
import android.wjf.android06.feicuiedu.com.newsapp.net.NewsRequestNet;
import android.wjf.android06.feicuiedu.com.newsapp.net.RequestNet;
import android.wjf.android06.feicuiedu.com.newsapp.ui.adapter.NewsAdapter;

import com.limxing.xlistview.view.XListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

public class FragmentNews0 extends Fragment {

    private Context context;

    //动态加载Button

    private LinearLayout ll;

    private XListView lvMain;

    private LayoutInflater lif;

    private List<News> newsList;
    private List<SubType> newsListSubType;
    private int subid = 1;
    private long newsNumInDB = 0;
    private long subTypeNumInDB = 0;


    private NewsDBManager newsDBManager;
    private NewsSubTypeDBManager newsSubTypeDBManager;

    private NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();
        lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_news, container, false);
        lvMain = (XListView) view.findViewById(R.id.lv_main);
        ll = (LinearLayout) view.findViewById(R.id.view);

        newsSubTypeDBManager = new NewsSubTypeDBManager(context);
        newsDBManager = new NewsDBManager(context);

        subTypeNumInDB = newsSubTypeDBManager.getSubidCount();
        newsListSubType = newsSubTypeDBManager.querySubType();
        if (newsListSubType.size() != 0) {
            subid = newsListSubType.get(0).getSubid();
            initButton();
            showData();
        } else {
            new RequestNet().requestNet(context, new RequestNet.IResponse() {
                @Override
                public void onReturn() {
                    newsListSubType = newsSubTypeDBManager.querySubType();
                    subid = newsListSubType.get(0).getSubid();
                    Log.d("21221", "onReturn: " + subid);
                    initButton();
                    showData();
                }
            });
        }
        return view;
    }

    public void initButton() {

        for (int i = 0; i < newsListSubType.size(); i++) {
            SubType subType = newsListSubType.get(i);
            Button btn = new Button(context.getApplicationContext());
            btn.setText(subType.getSubgroup());
            btn.setId(subType.getSubid());
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

            newsNumInDB = 0;
            subid = view.getId();

            Log.d("2323", "onClick: subid=" + subid);
            showData();

        }
    };

    public void showData() {
        newsNumInDB = newsDBManager.getCount(subid);
        Log.d("2323", "onClick: newsNumInDB=" + newsNumInDB);
        if (newsNumInDB == 0) {
            new NewsRequestNet().newsRequestNet(context, subid, new NewsRequestNet.IResponse2() {
                @Override
                public void onReturn() {
                    newsNumInDB = newsDBManager.getCount(subid);
                    if (newsNumInDB < Gobal.MAIN_ROWS) {
                        newsList = newsDBManager.queryNews((int) newsNumInDB, 0, subid);
                    } else {
                        newsList = newsDBManager.queryNews(Gobal.MAIN_ROWS, 0, subid);
                    }

                    Log.d("newsList", "newsList.size=" + newsList);
                    adapter = new NewsAdapter(newsList, context);

                    lvMain.setXListViewListener(listViewListener);
                    lvMain.setPullRefreshEnable(true);
                    lvMain.setPullLoadEnable(true);

                    lvMain.setAdapter(adapter);
                }
            });



        } else {

            if (newsNumInDB < Gobal.MAIN_ROWS) {
                newsList = newsDBManager.queryNews((int) newsNumInDB, 0, subid);
            } else {
                newsList = newsDBManager.queryNews(Gobal.MAIN_ROWS, 0, subid);
            }
            adapter = new NewsAdapter(newsList, context);

            lvMain.setXListViewListener(listViewListener);
            lvMain.setPullRefreshEnable(true);
            lvMain.setPullLoadEnable(true);

            lvMain.setAdapter(adapter);
        }
    }

    private XListView.IXListViewListener listViewListener = new XListView.IXListViewListener() {

        // 下拉方法
        @Override
        public void onRefresh() {
            // 加载数据。。。。。。。。。。。。。。。。。。。
            Log.d("refresh", "11111111111111111");
            new NewsRequestNet().newsRequestNet(context, subid, new NewsRequestNet.IResponse2() {
                @Override
                public void onReturn() {
                    newsNumInDB = newsDBManager.getCount(subid);
                    if (newsNumInDB < Gobal.MAIN_ROWS) {
                        newsList = newsDBManager.queryNews((int) newsNumInDB, 0, subid);
                    } else {
                        newsList = newsDBManager.queryNews(Gobal.MAIN_ROWS, 0, subid);
                    }

                    adapter.notifyDataSetChanged();
                    // 加载完毕
                    lvMain.stopLoadMore();
                    lvMain.stopRefresh();
                    lvMain.setRefreshTime(getSystime());
                }
            });

        }

        // 上推方法
        @Override
        public void onLoadMore() {
            // 加载数据。。。。。。。。。。。。。。。。。。。
            Log.d("onLoadMore", "2222222222222");
             newsList.addAll(getShangTuiData());
            adapter.notifyDataSetChanged();
            lvMain.stopLoadMore();
            lvMain.stopRefresh();
        }
    };

    /**
     * 下拉数据处理
     *
     * @return
     */
/*    private void getXiaLaData() {

        new NewsRequestNet().newsRequestNet(context, subid, new NewsRequestNet.IResponse2() {
            @Override
            public void onReturn() {
                newsNumInDB = newsDBManager.getCount(subid);
                if (newsNumInDB < Gobal.MAIN_ROWS) {
                    newsList = newsDBManager.queryNews((int) newsNumInDB, 0, subid);
                } else {
                    newsList = newsDBManager.queryNews(Gobal.MAIN_ROWS, 0, subid);
                }
            }
        });
    }*/

    /**
     * 上推数据处理
     *
     * @return
     */
    private List<News> getShangTuiData() {

        List<News> upList = new ArrayList<News>();

        long count = newsDBManager.getCount(subid);
        int tmp = (int) count - newsList.size();

        if (tmp < Gobal.MAIN_ROWS) {
            upList = newsDBManager.queryNews(tmp, newsList.size(), subid);
        } else {
            upList = newsDBManager.queryNews(Gobal.MAIN_ROWS, newsList.size(), subid);
        }
       // newsList.addAll(upList);


        return upList;
    }

    private String getSystime() {
        String systime;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        systime = dateFormat.format(new Date(System.currentTimeMillis()));
        return systime;
    }

}

