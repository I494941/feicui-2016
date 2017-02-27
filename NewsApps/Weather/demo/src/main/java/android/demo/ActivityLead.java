package android.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ContentView(R.layout.activity_lead)
public class ActivityLead extends AppCompatActivity {
    private static final String TAG = "ActivityLead";

    private ImageView im1;
    private ImageView im11;

    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;
    private ImageView[] points = new ImageView[4];

    private LeadImgAdapter adapter;
    private List<View> viewList;

    int currentItem;
    private ScheduledExecutorService executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        initPagerData();

        initLeadPoints();
        setPoint(0);

        //初始化适配器
        adapter = new LeadImgAdapter(viewList);
        //设置适配器
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(listener);

        viewPager.setCurrentItem(currentItem);

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

                        if(currentItem >= 3){
                            currentItem = -1;
                        }
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

    private void initPagerData() {
        //设置每一个具体界面的样式
        viewList = new ArrayList<View>();

        View v = getLayoutInflater().inflate(R.layout.lead_1, null);
        im1 = (ImageView) v.findViewById(R.id.imageView1);
        im11 = (ImageView) v.findViewById(R.id.imageView11);
        x.image().bind(im1, "https://pic4.zhimg.com/03b2d57be62b30f158f48f388c8f3f33_b.png");
        x.image().bind(im11, "https://pic1.zhimg.com/4373a4f045e5e9ae16ebd6a624bf6228_b.png");
        viewList.add(v);
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
            currentItem = arg0;

            startAutoScroll(); // 手动切换完成后恢复自动播放

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
