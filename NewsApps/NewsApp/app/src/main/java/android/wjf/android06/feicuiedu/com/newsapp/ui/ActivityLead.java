package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.wjf.android06.feicuiedu.com.newsapp.R;
import android.wjf.android06.feicuiedu.com.newsapp.ui.adapter.LeadImgAdapter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_lead)
public class ActivityLead extends AppCompatActivity {
    private static final String TAG = "ActivityLead";

    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;
    private ImageView[] points = new ImageView[4];

    private LeadImgAdapter adapter;
    private List<View> viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置存储信息
        SharedPreferences preferences = getSharedPreferences("runconfig", Context.MODE_PRIVATE);
        boolean isFirstRun = preferences.getBoolean("isFirstRun", true);
        Log.d(TAG, "onCreate: ...."+isFirstRun);
        if (!isFirstRun) {
            Intent intent = new Intent();
            intent.setClass(this, ActivityLogo.class);
            startActivity(intent);
            finish();
        }
        // 从当前引导页面开始执行
        else {
            x.view().inject(this);

            initPagerData();

            initLeadPoints();
            setPoint(0);

            //初始化适配器
            adapter = new LeadImgAdapter(viewList);
            //设置适配器
            viewPager.setAdapter(adapter);

            viewPager.setOnPageChangeListener(listener);

        }
    }

    private void initPagerData() {
        //设置每一个具体界面的样式
        viewList = new ArrayList<View>();
        viewList.add(getLayoutInflater().inflate(R.layout.lead_1, null));
        viewList.add(getLayoutInflater().inflate(R.layout.lead_2, null));
        viewList.add(getLayoutInflater().inflate(R.layout.lead_3, null));
        viewList.add(getLayoutInflater().inflate(R.layout.lead_4, null));
    }

    private void initLeadPoints() {
        points[0] = (ImageView) findViewById(R.id.iv_p1);
        points[1] = (ImageView) findViewById(R.id.iv_p2);
        points[2] = (ImageView) findViewById(R.id.iv_p3);
        points[3] = (ImageView) findViewById(R.id.iv_p4);
    }

    private void setPoint(int index) {
        for (int i = 0; i < points.length; i++) {
            if (i == index) {
                points[i].setAlpha(255);
            } else {
                points[i].setAlpha(100);
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
            if (arg0 >= 3) {
                Intent intent = new Intent();
                intent.setClass(ActivityLead.this, ActivityLogo.class);
                startActivity(intent);
                finish();
                SharedPreferences preferences = getSharedPreferences("runconfig", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isFirstRun", false);
                editor.commit();
            }
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
