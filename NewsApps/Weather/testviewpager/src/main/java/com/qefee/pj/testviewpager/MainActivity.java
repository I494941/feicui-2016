package com.qefee.pj.testviewpager;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    /**
     * log tag for MainActivity
     */
    private static final String TAG = "MainActivity";

    ViewPager viewPager;

    String[] imageUris = {
            "https://pic4.zhimg.com/03b2d57be62b30f158f48f388c8f3f33_b.png",
            "https://pic1.zhimg.com/4373a4f045e5e9ae16ebd6a624bf6228_b.png",
            "https://pic2.zhimg.com/0364e17a1561f48793993d8bf1cdc785_b.png",
            "https://pic2.zhimg.com/55fa74ff3eba164ed1db2037df1a8311_b.png",
            "https://pic4.zhimg.com/5dc30569c06e7c6266c9809f6eb80a7b_b.jpg"
    };

    SimpleDraweeView[] simpleDraweeViews;

    int currentItem;
    private ScheduledExecutorService executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int size = initSize();
        initTextViews(size);
        initViewPager();
    }

    @Override
    protected void onResume() {
        super.onResume();

        startAutoScroll(); // activity激活时候自动播放
    }

    @Override
    protected void onPause() {
        super.onPause();

        stopAutoScroll(); // activity暂停时候停止自动播放
    }

    private void startAutoScroll() {
        stopAutoScroll();

        executor = Executors.newSingleThreadScheduledExecutor();
        Runnable command = new Runnable() {
            @Override
            public void run() {
                selectNextItem();
            }

            private void selectNextItem() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem(++currentItem);
                    }
                });
            }
        };
        int delay = 2;
        int period = 2;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        executor.scheduleAtFixedRate(command, delay, period, timeUnit);
    }

    private void stopAutoScroll() {
        if (executor != null) {
            executor.shutdownNow();
        }
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPage);

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Integer.MAX_VALUE; // 取一个大数字
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Log.i(TAG, "instantiateItem: instantiateItem + position = " + position);
                SimpleDraweeView t = simpleDraweeViews[position % simpleDraweeViews.length];
                container.addView(t);

                Uri uri = Uri.parse(imageUris[position % simpleDraweeViews.length]);
                t.setImageURI(uri);

                return t;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                Log.i(TAG, "destroyItem: + position = " + position);
                container.removeView((View) object);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentItem = position;

                startAutoScroll(); // 手动切换完成后恢复自动播放
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        currentItem = imageUris.length * 1000000; // 取一个中间的大数字, 防止接近边界
        viewPager.setCurrentItem(currentItem);
    }

    private void initTextViews(int size) {
        SimpleDraweeView[] tvs = new SimpleDraweeView[size];

        for (int i = 0; i < tvs.length; i++) {
            tvs[i] = new SimpleDraweeView(this);
            tvs[i].getHierarchy().setPlaceholderImage(R.mipmap.ic_launcher);

            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            tvs[i].setLayoutParams(layoutParams);
            simpleDraweeViews = tvs;
        }
    }

    private int initSize() {
        int size;
        if (imageUris.length > 3) {
            size = imageUris.length;
        } else {
            size = imageUris.length * 2; // 小于3个时候, 需要扩大一倍, 防止出错
        }
        return size;
    }
}
