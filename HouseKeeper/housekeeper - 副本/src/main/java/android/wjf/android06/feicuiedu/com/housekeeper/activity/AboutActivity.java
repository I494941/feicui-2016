package android.wjf.android06.feicuiedu.com.housekeeper.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.wjf.android06.feicuiedu.com.housekeeper.R;
import android.wjf.android06.feicuiedu.com.housekeeper.base.BaseActivity;

/**
 * Created by ad06-wjf on 2016/11/15.
 */

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        // 初始化ActionBar @see super class ActionBarActivity
        String title = getResources().getString(R.string.about);
        initActionBar(title, R.drawable.btn_homeasup_default, -1, clickListener);
    }

    public void initActionBar(String s,int i,int j,View.OnClickListener view) {


    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewID = v.getId();
            switch (viewID) {
                case R.id.iv_left:
                    // 获取来自哪里
                    String fromClassName = getIntent().getStringExtra("className");
                    // 无值默认是从主页面进入的
                    if (fromClassName == null || fromClassName.equals("")) {
                        startActivity(HomeActivity.class);
                        finish();
                        return;
                    }
                    // 从设置页面进入的
                    if (fromClassName.equals(SettingActivity.class.getSimpleName())) {
                        startActivity(SettingActivity.class);
                    } else {
                        startActivity(HomeActivity.class);
                    }
                    finish();
                    break;
                default:
                    break;
            }
        }
    };

}
