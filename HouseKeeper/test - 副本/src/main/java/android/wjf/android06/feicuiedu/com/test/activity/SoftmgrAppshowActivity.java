package android.wjf.android06.feicuiedu.com.test.activity;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.test.base.BaseActivity;
import android.wjf.android06.feicuiedu.com.test.R;


/**
 * 显示（所有，系统，用户）软件列表界面 -------------------- * del app 的系统广播 action
 */
public class SoftmgrAppshowActivity extends BaseActivity {

    private ImageView ivLeft;
    private TextView tvTitle;
    private ImageView ivRight;

    private RelativeLayout rlSoftAll;
    private RelativeLayout rlSoftSys;
    private RelativeLayout rlSoftUse;

    private Intent intent;
    private Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_softmgr);

        context = this;

        ivLeft = (ImageView) findViewById(R.id.iv_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivRight = (ImageView) findViewById(R.id.iv_right);

        rlSoftAll = (RelativeLayout) findViewById(R.id.rl_soft_all);
        rlSoftSys = (RelativeLayout) findViewById(R.id.rl_soft_sys);
        rlSoftUse = (RelativeLayout) findViewById(R.id.rl_soft_use);

        // 初始化ActionBar @see super class ActionBarActivity
        String title = getResources().getString(R.string.softmgr);
        initActionBar(title, R.drawable.btn_return, -1, clickListener);

        rlSoftAll.setOnClickListener(ocl);
        rlSoftSys.setOnClickListener(ocl);
        rlSoftUse.setOnClickListener(ocl);


    }

    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.rl_soft_all:
                    intent = new Intent();
                    intent.setClass(context,AppShowActivity.class);
                    intent.putExtra("view",0);
                    startActivity(intent);
                    break;
                case R.id.rl_soft_sys:
                    intent = new Intent();
                    intent.setClass(context,AppShowActivity.class);
                    intent.putExtra("view",1);
                    startActivity(intent);
                    break;
                case R.id.rl_soft_use:
                    intent = new Intent();
                    intent.setClass(context,AppShowActivity.class);
                    intent.putExtra("view",2);
                    startActivity(intent);
                    break;
            }
        }
    };


    public void initActionBar(String s, int i, int j, View.OnClickListener view) {

        tvTitle.setText(s);
        ivLeft.setImageResource(i);
        ivLeft.setOnClickListener(view);
        ivRight.setVisibility(View.INVISIBLE);

    }

    /**
     * 监听页面进行跳转
     */
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewID = v.getId();
            switch (viewID) {
                case R.id.iv_left:
                    startActivity(HomeActivity.class);
                    finish();
                    break;
            }
        }
    };


}

