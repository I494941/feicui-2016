package contacts.android.wjf.android06.feicuiedu.com.viewpagedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ad06-wjf on 2016/11/3.
 */

public class LeadActivity extends AppCompatActivity {

    private ImageView[] icons = new ImageView[3];
    private TextView tv_skip;
    private ViewPager viewPager;
    private BasePagerAdapter leadPagerAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lead_activity);
        SharedPreferences preferences = getSharedPreferences("lead_config", Context.MODE_PRIVATE);
        boolean isFirstRun = preferences.getBoolean("isFirstRun", true);
        if (!isFirstRun) {
            startActivity(LogoActivity.class);
            finish();
        }
        // 从当前引导页面开始执行
        else {
            icons[0] = (ImageView) findViewById(R.id.icon0);
            icons[1] = (ImageView) findViewById(R.id.icon1);
            icons[2] = (ImageView) findViewById(R.id.icon2);
            icons[0].setImageResource(R.drawable.adware_style_selected);
            tv_skip = (TextView) findViewById(R.id.tv_skip);
            tv_skip.setVisibility(View.INVISIBLE);
            //tv_skip.setOnClickListener(ocl);

            viewPager = (ViewPager) findViewById(R.id.viewpager);
            leadPagerAdapter = new BasePagerAdapter(this);
            viewPager.setAdapter(leadPagerAdapter);

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
    }


    public void onPageSelected(int arg0) {
        // 到达最后一个page时，显示出skip文本
        tv_skip.setVisibility(View.INVISIBLE);
        if (arg0 >= 2) {
            tv_skip.setVisibility(View.VISIBLE);
        }
        // 更新下标图标
        for (int i = 0; i < icons.length; i++) {
            icons[i].setImageResource(R.drawable.adware_style_default);
        }
        icons[arg0].setImageResource(R.drawable.adware_style_selected);
    }

    //普通跳转
    protected void startActivity(Class<?> targetClass) {
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
    }

}
