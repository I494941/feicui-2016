package android.wjf.android06.feicuiedu.com.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.test.base.BaseActivity;
import android.wjf.android06.feicuiedu.com.test.view.ClearArcView;
import android.wjf.android06.feicuiedu.com.test.R;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

public class HomeActivity extends BaseActivity {


    private Context context;

    private Intent intent;
    private ImageView iv_actionbar_left;//左边按钮
    private ImageView iv_actionbar_right;//右边按钮

    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.iv_left:
                    intent = new Intent();
                    intent.setClass(context,AboutActivity.class);
                    startActivity(intent);
                    break;
                case R.id.iv_right:
                    intent = new Intent();
                    intent.setClass(context,SettingActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;

        TextView tv_score = (TextView) findViewById(R.id.tv_score);
        ClearArcView cav = (ClearArcView) findViewById(R.id.homeclear_arc);
        cav.setAngleWithAnim(100);
        tv_score.setText("100");

        iv_actionbar_left = (ImageView) findViewById(R.id.iv_left);
        iv_actionbar_right = (ImageView) findViewById(R.id.iv_right);

        iv_actionbar_left.setOnClickListener(ocl);
        iv_actionbar_right.setOnClickListener(ocl);


    }



    /**
     * 按键监听方法
     */
    public void hitHomeitem(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.ll_rocket: //跳转到手机加速页面
                startActivity(SpeedupActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_softmgr: //跳转到软件管理页面
                startActivity(SoftmgrAppshowActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_phonemgr: //跳转到手机检测页面
                startActivity(PhonemgrActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_telmgr: //跳转到通信大全页面
                startActivity(TelmsgActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_filemgr: //跳转到文件管理页面
                startActivity(FilemgrActivity.class, R.anim.in_down, R.anim.out_up);
                break;
            case R.id.ll_sdclean: //跳转到垃圾清理页面
                startActivity(ClearActivity.class, R.anim.in_down, R.anim.out_up);
                break;
        }
    }
}
