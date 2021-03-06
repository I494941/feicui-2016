package android.wjf.android06.feicuiedu.com.test.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.test.base.BaseActivity;
import android.wjf.android06.feicuiedu.com.test.adapter.BasePagerAdapter;
import android.wjf.android06.feicuiedu.com.test.service.MusicService;
import android.wjf.android06.feicuiedu.com.test.R;


/**
 * Created by ad06-wjf on 2016/11/14.
 */

public class LeadActivity extends BaseActivity implements View.OnClickListener {

    private ImageView[] icons = new ImageView[3];
    private TextView tv_skip;
    private ViewPager viewPager;
    private BasePagerAdapter leadPagerAdapter;
    private boolean isFromSetting;// 是否来自设置页面

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String fromClassName = intent.getStringExtra("className");
        if (fromClassName != null && fromClassName.equals("SettingActivity")) {
            isFromSetting = true;
        }
        //设置存储信息
        SharedPreferences preferences = getSharedPreferences("lead_config", Context.MODE_PRIVATE);
        boolean isFirstRun = preferences.getBoolean("isFirstRun", true);
        if (!isFirstRun) {
            startActivity(LogoActivity.class);
            finish();
        }
        // 从当前引导页面开始执行
        else {
            setContentView(R.layout.activity_lead);
            // 初始化引导页面小图标+skip (5个小图标 + 1个skip文字)
            initLeadIcon();
            // 初始化引导页面ViewPager视图 (给ViewPager设置Adapter)
            initViewPager();
            // 初始化引导页面ViewPager内显示的视图数据 (向ViewPager的Adapter内添加视图(图片))
            initPagerData();

            //启动音乐
            Intent serviceIntent = new Intent(this, MusicService.class);
            startService(serviceIntent);

        }


    }


    /**
     * 初始化引导图片
     */

    private void initLeadIcon() {
        icons[0] = (ImageView) findViewById(R.id.icon1);
        icons[1] = (ImageView) findViewById(R.id.icon2);
        icons[2] = (ImageView) findViewById(R.id.icon3);
        icons[0].setImageResource(R.drawable.adware_style_selected);
        tv_skip = (TextView) findViewById(R.id.tv_skip);
        tv_skip.setVisibility(View.VISIBLE);
        tv_skip.setOnClickListener(this);
    }


    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        leadPagerAdapter = new BasePagerAdapter(this);
        viewPager.setAdapter(leadPagerAdapter);
        viewPager.setOnPageChangeListener(pageChangeListener);
    }

    /**
     * 初始化页面信息
     */
    private void initPagerData() {
        ImageView imageView = null;
        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.adware_style_applist);
        leadPagerAdapter.addViewToAdapter(imageView);
        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.adware_style_banner);
        leadPagerAdapter.addViewToAdapter(imageView);
        imageView = (ImageView) getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        imageView.setImageResource(R.drawable.adware_style_creditswall);
        leadPagerAdapter.addViewToAdapter(imageView);
        leadPagerAdapter.notifyDataSetChanged();
    }

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int arg0) {
            // 到达最后一个page时，显示出skip文本
            tv_skip.setVisibility(View.VISIBLE);
            if (arg0 == 1) {
                tv_skip.setVisibility(View.INVISIBLE);
            } // 更新下标图标
            for (int i = 0; i < icons.length; i++) {
                icons[i].setImageResource(R.drawable.adware_style_default);
            }
            icons[arg0].setImageResource(R.drawable.adware_style_selected);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    /**
     * 保存配置信息
     */
    private void savePreferences() {
        SharedPreferences preferences = getSharedPreferences("lead_config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstRun", false);
        editor.commit();
    }

    public void onClick(View v) {
        // 编辑保存配置信息(不再是第一次运行此引导页面)
        savePreferences();

        // 界面跳转
        if (isFromSetting) {
            startActivity(SettingActivity.class);
        } else {
            startActivity(LogoActivity.class);
        }
        //停止音乐
        Intent musicIntent = new Intent(this, MusicService.class);
        stopService(musicIntent);
        finish();
    }


}
