package com.example.testhomeentry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by ad06-wjf on 2016/10/26.
 */

public class MianActivityEntry1 extends AppCompatActivity {

    Context context = this;
    private ImageView ivEntry1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout_entry1);

        ivEntry1 = (ImageView) findViewById(R.id.iv_enrty_1);


        Animation animation = null;
        animation =  AnimationUtils.loadAnimation(context,R.anim.rotate);
        animation.setAnimationListener(al);
        ivEntry1.startAnimation(animation);

    }

    Animation.AnimationListener al = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {


        }

        @Override
        public void onAnimationEnd(Animation animation) {
            // 跳转
            Intent intent = new Intent();
            intent.setClass(context,MianActivityEntry2.class);
            startActivity(intent);

            overridePendingTransition(R.anim.scale,R.anim.translate);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
}
