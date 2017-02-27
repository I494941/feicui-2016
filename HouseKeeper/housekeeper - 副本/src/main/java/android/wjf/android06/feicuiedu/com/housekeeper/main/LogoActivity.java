package android.wjf.android06.feicuiedu.com.housekeeper.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.wjf.android06.feicuiedu.com.housekeeper.R;


/**
 * Created by ad06-wjf on 2016/11/14.
 */

/**
 * 欢迎界面 *
 */
public class LogoActivity extends AppCompatActivity {

    private ImageView img_logo;
    private Animation animation = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        // 初始控件及动画
        img_logo = (ImageView) findViewById(R.id.iv_logo);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_logo);
        animation.setAnimationListener(animationListener);
        // logo图像控件开始动画
        img_logo.startAnimation(animation);
    }

    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        //动画开始
        @Override
        public void onAnimationStart(Animation animation) {
        }
        //动画重复

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
        //动画结束

        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(LogoActivity.this, TelmsgActivity.class);
            startActivity(intent);
            finish();
        }
    };


}
