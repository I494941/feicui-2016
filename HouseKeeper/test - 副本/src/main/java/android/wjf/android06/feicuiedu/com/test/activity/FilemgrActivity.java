package android.wjf.android06.feicuiedu.com.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.test.base.BaseActivity;
import android.wjf.android06.feicuiedu.com.test.R;

/**
 * Created by ad06-wjf on 2016/11/17.
 */
public class FilemgrActivity extends BaseActivity {

    private ImageView ivLeft;
    private TextView tvTitle;
    private ImageView ivRight;



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


        // 初始化ActionBar @see super class ActionBarActivity
        String title = getResources().getString(R.string.filemgr);
        initActionBar(title, R.drawable.btn_return, -1, clickListener);



    }




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
