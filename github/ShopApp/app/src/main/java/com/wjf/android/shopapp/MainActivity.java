package com.wjf.android.shopapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Context context;

    @BindView(R.id.viewPage)
    private ViewPager viewPager;

    @BindView(R.id.iv_player_1)
    private ImageView ivPlayer1;
    @BindView(R.id.iv_player_2)
    private ImageView ivPlayer2;
    @BindView(R.id.iv_player_3)
    private ImageView ivPlayer3;
    @BindView(R.id.iv_player_4)
    private ImageView ivPlayer4;
    @BindView(R.id.iv_player_5)
    private ImageView ivPlayer5;

    @BindView(R.id.tv_category_1)
    private TextView tvCategory1;
    @BindView(R.id.iv_category_1_1)
    private ImageView ivCategory11;
    @BindView(R.id.iv_category_1_2)
    private ImageView ivCategory12;
    @BindView(R.id.iv_category_1_3)
    private ImageView ivCategory13;

    @BindView(R.id.tv_category_2)
    private TextView tvCategory2;
    @BindView(R.id.iv_category_2_1)
    private ImageView ivCategory21;
    @BindView(R.id.iv_category_2_2)
    private ImageView ivCategory22;
    @BindView(R.id.iv_category_2_3)
    private ImageView ivCategory23;
    @BindView(R.id.iv_category_2_4)
    private ImageView ivCategory24;

    @BindView(R.id.tv_category_3)
    private TextView tvCategory3;
    @BindView(R.id.iv_category_3_1)
    private ImageView ivCategory31;
    @BindView(R.id.iv_category_3_2)
    private ImageView ivCategory32;
    @BindView(R.id.iv_category_3_3)
    private ImageView ivCategory33;
    @BindView(R.id.iv_category_3_4)
    private ImageView ivCategory34;
    @BindView(R.id.iv_category_3_5)
    private ImageView ivCategory35;

    @BindView(R.id.swipe_container)
    private SwipeRefreshLayout swipeRefreshLayout;

    private ImageView[] points = new ImageView[5];

    private LeadImgAdapter adapter;
    private List<View> viewList = new ArrayList<>();

    private List<Map<String, Object>> playerList = new ArrayList<>();
    private List<Map<String, String>> photoList = new ArrayList<>();
    private List<Map<String, Object>> promoteGoodsList = new ArrayList<>();
    private List<Map<String, String>> imgList = new ArrayList<>();

    private List<Map<String, Object>> dataList = new ArrayList<>();
    private List<Map<String, Object>> goodsList = new ArrayList<>();
    private List<Map<String, String>> imgGoodsList = new ArrayList<>();

    private List<String> promoteList = new ArrayList<>();

    private LinearLayoutManager linearLayoutManager;
    private PromoteGoodsAdapter promoteGoodsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        context = this;

        initLeadPoints();
        setPoint(0);
        viewPager = (ViewPager) findViewById(R.id.viewPage);

        //初始化适配器
        adapter = new LeadImgAdapter(viewList);
        //设置适配器
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(listener);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_promote_goods);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        promoteGoodsAdapter = new PromoteGoodsAdapter(promoteList, this);
        recyclerView.setAdapter(promoteGoodsAdapter);

        requestNetF();
        requestNetS();

        //设置刷新时动画的颜色，可以设置4个
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

                // TODO Auto-generated method stub
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        // TODO Auto-generated method stub
                        requestNetF();
                        requestNetS();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 6000);
            }
        });

    }

    private void initPlayerData() {

        //设置每一个具体界面的样式
        viewList = new ArrayList<View>();

        View v1 = getLayoutInflater().inflate(R.layout.player_1, null);
        View v2 = getLayoutInflater().inflate(R.layout.player_2, null);
        View v3 = getLayoutInflater().inflate(R.layout.player_3, null);
        View v4 = getLayoutInflater().inflate(R.layout.player_4, null);
        View v5 = getLayoutInflater().inflate(R.layout.player_5, null);

        ivPlayer1 = (ImageView) v1.findViewById(R.id.iv_player_1);
        ivPlayer2 = (ImageView) v2.findViewById(R.id.iv_player_2);
        ivPlayer3 = (ImageView) v3.findViewById(R.id.iv_player_3);
        ivPlayer4 = (ImageView) v4.findViewById(R.id.iv_player_4);
        ivPlayer5 = (ImageView) v5.findViewById(R.id.iv_player_5);

        Glide.with(context).load(photoList.get(0).get("url")).centerCrop().into(ivPlayer1);
        Log.d("11111", "initPagerData: " + photoList.get(0).get("thumb"));
        Glide.with(context).load(photoList.get(1).get("url")).centerCrop().into(ivPlayer2);
        Glide.with(context).load(photoList.get(2).get("url")).centerCrop().into(ivPlayer3);
        Glide.with(context).load(photoList.get(3).get("url")).centerCrop().into(ivPlayer4);
        Glide.with(context).load(photoList.get(4).get("url")).centerCrop().into(ivPlayer5);

        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        viewList.add(v4);
        viewList.add(v5);
    }

    private void initPromoteGoodsData() {

        for (int i = 0; i < imgList.size(); i++) {

            String str = imgList.get(i).get("thumb");
            Log.d("hehe", "initPromoteGoodsData: " + imgList.size());
            Log.d("hehe", "initPromoteGoodsData: " + str);

            if (promoteList.size() == 0) {

                promoteList.add(str);
            } else {

                int k = 0;
                for (int j = 0; j < promoteList.size(); j++) {

                    if (promoteList.get(j).equals(str)) {

                        k++;
                    }
                }

                if(k == 0){

                    promoteList.add(str);
                }
            }
        }

        promoteGoodsAdapter.setMlist(promoteList);
        promoteGoodsAdapter.notifyDataSetChanged();
    }

    private void requestNetF() {

        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        Request request = new Request.Builder().url(Goble.URLF).build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                Log.d("000000", "onResponse: " + result);
                // imgList = new ArrayList<Map<String, String>>();
                Gson gson = new Gson();

                Map<String, Map<String, Object>> map = gson.fromJson(result, new TypeToken<Map<String, Map<String, Object>>>() {
                }.getType());
                Log.d("111111", "onResponse: " + map.get("data").get("player").toString());

                playerList = (List<Map<String, Object>>) map.get("data").get("player");
                Log.d("222222", "onResponse: " + playerList.toString());
                promoteGoodsList = (List<Map<String, Object>>) map.get("data").get("promote_goods");
                Log.d("333333", "onResponse: " + promoteGoodsList.toString());

                for (int i = 0; i < playerList.size(); i++) {

                    Map<String, String> photoMap = (Map<String, String>) playerList.get(i).get("photo");
                    Log.d("444444", "onResponse: " + photoMap.toString());
                    photoList.add(photoMap);
                }
                for (int i = 0; i < promoteGoodsList.size(); i++) {

                    Map<String, String> imgMap = (Map<String, String>) promoteGoodsList.get(i).get("img");
                    Log.d("555555", "onResponse: " + imgMap.toString());
                    imgList.add(imgMap);
                }

                //通过handler更新UI
                Message message1 = new Message();
                message1.obj = photoList;
                message1.what = 1;
                handler.sendMessage(message1);
                Message message2 = new Message();
                message2.obj = imgList;
                message2.what = 2;
                handler.sendMessage(message2);
            }

        });
    }

    private void initCategoryData() {

        tvCategory1 = (TextView) findViewById(R.id.tv_category_1);
        ivCategory11 = (ImageView) findViewById(R.id.iv_category_1_1);
        ivCategory12 = (ImageView) findViewById(R.id.iv_category_1_2);
        ivCategory13 = (ImageView) findViewById(R.id.iv_category_1_3);

        tvCategory2 = (TextView) findViewById(R.id.tv_category_2);
        ivCategory21 = (ImageView) findViewById(R.id.iv_category_2_1);
        ivCategory22 = (ImageView) findViewById(R.id.iv_category_2_2);
        ivCategory23 = (ImageView) findViewById(R.id.iv_category_2_3);
        ivCategory24 = (ImageView) findViewById(R.id.iv_category_2_4);

        tvCategory3 = (TextView) findViewById(R.id.tv_category_3);
        ivCategory31 = (ImageView) findViewById(R.id.iv_category_3_1);
        ivCategory32 = (ImageView) findViewById(R.id.iv_category_3_2);
        ivCategory33 = (ImageView) findViewById(R.id.iv_category_3_3);
        ivCategory34 = (ImageView) findViewById(R.id.iv_category_3_4);
        ivCategory35 = (ImageView) findViewById(R.id.iv_category_3_5);

        String name1 = String.valueOf(dataList.get(0).get("name"));
        String name2 = String.valueOf(dataList.get(1).get("name"));
        String name3 = String.valueOf(dataList.get(2).get("name"));
        tvCategory1.setText(name1);
        tvCategory2.setText(name2);
        tvCategory3.setText(name3);

        List<Map<String, Object>> goodsLit1 = (List<Map<String, Object>>) dataList.get(0).get("goods");
        Log.d(">>>>>>", "initCategoryData: " + goodsLit1.toString());
        Map<String, String> imgMap11 = (Map<String, String>) goodsLit1.get(0).get("img");
        Log.d(">>>>>>>", "initCategoryData: " + imgMap11.toString());
        Map<String, String> imgMap12 = (Map<String, String>) goodsLit1.get(1).get("img");
        Map<String, String> imgMap13 = (Map<String, String>) goodsLit1.get(2).get("img");

        Glide.with(context).load(imgMap11.get("thumb")).into(ivCategory11);
        Glide.with(context).load(imgMap12.get("thumb")).into(ivCategory12);
        Glide.with(context).load(imgMap13.get("thumb")).into(ivCategory13);

        List<Map<String, Object>> goodsLit2 = (List<Map<String, Object>>) dataList.get(1).get("goods");
        Log.d(">>>>>>>>", "initCategoryData: " + goodsLit2.toString());
        Map<String, String> imgMap21 = (Map<String, String>) goodsLit2.get(0).get("img");
        Log.d(">>>>>>>>>", "initCategoryData: " + imgMap21.toString());
        Map<String, String> imgMap22 = (Map<String, String>) goodsLit2.get(1).get("img");
        Map<String, String> imgMap23 = (Map<String, String>) goodsLit2.get(2).get("img");
        Map<String, String> imgMap24 = (Map<String, String>) goodsLit2.get(3).get("img");

        Glide.with(context).load(imgMap21.get("thumb")).centerCrop().into(ivCategory21);
        Glide.with(context).load(imgMap22.get("thumb")).centerCrop().into(ivCategory22);
        Glide.with(context).load(imgMap23.get("thumb")).centerCrop().into(ivCategory23);
        Glide.with(context).load(imgMap24.get("thumb")).centerCrop().into(ivCategory24);

        List<Map<String, Object>> goodsLit3 = (List<Map<String, Object>>) dataList.get(2).get("goods");
        Log.d(">>>>>>>>>>", "initCategoryData: " + goodsLit2.toString());
        Map<String, String> imgMap31 = (Map<String, String>) goodsLit3.get(0).get("img");
        Log.d(">>>>>>>>>>", "initCategoryData: " + imgMap31.toString());
        Map<String, String> imgMap32 = (Map<String, String>) goodsLit3.get(1).get("img");
        Map<String, String> imgMap33 = (Map<String, String>) goodsLit3.get(2).get("img");
        Map<String, String> imgMap34 = (Map<String, String>) goodsLit3.get(3).get("img");
        Map<String, String> imgMap35 = (Map<String, String>) goodsLit3.get(4).get("img");

        Glide.with(context).load(imgMap31.get("thumb")).centerCrop().into(ivCategory31);
        Glide.with(context).load(imgMap32.get("thumb")).centerCrop().into(ivCategory32);
        Glide.with(context).load(imgMap33.get("thumb")).centerCrop().into(ivCategory33);
        Glide.with(context).load(imgMap34.get("thumb")).centerCrop().into(ivCategory34);
        Glide.with(context).load(imgMap35.get("thumb")).centerCrop().into(ivCategory35);
    }

    private void requestNetS() {

        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        Request request = new Request.Builder().url(Goble.URLS).build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                Log.d("20000", "onResponse: " + result);

                Message message = new Message();
                message.obj = result;
                message.what = 3;
                handler.sendMessage(message);
            }

        });
    }


    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 1) {

                photoList = (List<Map<String, String>>) msg.obj;
                Log.d("1111111", "handleMessage: " + photoList.toString());
            } else if (msg.what == 2) {

                imgList = (List<Map<String, String>>) msg.obj;
                Log.d("2222222", "handleMessage: " + imgList.toString());
            } else if (msg.what == 3) {

                String result = (String) msg.obj;
                Gson gson = new Gson();

                Map<String, Object> map = gson.fromJson(result, new TypeToken<Map<String, Object>>() {
                }.getType());
                Log.d("11111111", "onResponse: " + map.get("data").toString());

                dataList = (List<Map<String, Object>>) map.get("data");
                Log.d("222222222", "handleMessage: " + dataList.toString());
            }

            initPlayerData();

            initPromoteGoodsData();

            initCategoryData();

            adapter.setList(viewList);
            adapter.notifyDataSetChanged();

        }
    };

    private void initLeadPoints() {

        points[0] = (ImageView) findViewById(R.id.iv_p1);
        points[1] = (ImageView) findViewById(R.id.iv_p2);
        points[2] = (ImageView) findViewById(R.id.iv_p3);
        points[3] = (ImageView) findViewById(R.id.iv_p4);
        points[4] = (ImageView) findViewById(R.id.iv_p5);
    }

    private void setPoint(int index) {

        for (int i = 0; i < points.length; i++) {

            if (i == index) {

                points[i].setAlpha(1f);
            } else {

                points[i].setAlpha(0.3f);
            }
        }
    }

    /**
     * 当界面切换后调用
     */
    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        /**当界面切换后调用*/
        @Override
        public void onPageSelected(int arg0) {

            setPoint(arg0);

        }

        /**界面切换时调用*/
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        /**滑动状态变化时调用*/
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

    };
}
