package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.wjf.android06.feicuiedu.com.newsapp.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * Created by ad06-wjf on 2016/11/30.
 */
@ContentView(R.layout.activity_logo)
public class ActivityLogo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        ImageView logo = (ImageView) findViewById(R.id.iv_logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.logo);

        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            //动画启动时调用
            @Override
            public void onAnimationStart(Animation animation) {
            }

            //动画重复时调用
            @Override
            public void onAnimationRepeat(Animation animation) {

            } //动画结束时调用

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent();
                intent.setClass(ActivityLogo.this, FragmentMain.class);
                startActivity(intent);
                ActivityLogo.this.finish();
            }
        });
        logo.setAnimation(animation);
    }
}
