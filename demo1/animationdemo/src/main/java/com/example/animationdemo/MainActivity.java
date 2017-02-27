package com.example.animationdemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by ad06-wjf on 2016/10/25.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Context context;

    //天气
    private ImageView ivWeather;

    //透明渐变按钮
    private Button btnAlpha;

    //旋转按钮
    private Button btnRotate;

    //缩放按钮
    private Button btnScale;

    //位移按钮
    private Button btnTranslate;

    //动画组合按钮
    private Button btnSet;

    private Button btnJump;

    private ImageView ivTt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        context = this;

        btnAlpha = (Button) findViewById(R.id.btn_alpha);
        btnRotate = (Button) findViewById(R.id.btn_rotate);
        btnScale = (Button) findViewById(R.id.btn_scale);
        btnTranslate = (Button) findViewById(R.id.btn_translate);
        btnSet = (Button) findViewById(R.id.btn_set);
        btnJump = (Button) findViewById(R.id.btn_jump);

        ivTt = (ImageView) findViewById(R.id.iv_tt1);

        ivWeather = (ImageView) findViewById(R.id.iv_weather);

        btnAlpha.setOnClickListener(ocl);
        btnRotate.setOnClickListener(ocl);
        btnScale.setOnClickListener(ocl);
        btnTranslate.setOnClickListener(ocl);
        btnSet.setOnClickListener(ocl);
        btnJump.setOnClickListener(ocl);

        //让帧动画运行起来
        AnimationDrawable animationDrawable = (AnimationDrawable) ivWeather.getBackground();
        animationDrawable.start();

    }

    private View.OnClickListener ocl = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            Animation anim =  null;
            switch (view.getId()){
                case R.id.btn_alpha:

                    // 透明动画执行过程
                    anim = AnimationUtils.loadAnimation(context,R.anim.alpha);
                    break;
                case R.id.btn_rotate:

                    // 旋转动画
                    anim = AnimationUtils.loadAnimation(context,R.anim.rotate);
                    break;
                case R.id.btn_scale:

                    // 缩放动画
                    anim = AnimationUtils.loadAnimation(context,R.anim.scale);
                    break;
                case R.id.btn_translate:

                    // 位移动画
                    anim = AnimationUtils.loadAnimation(context,R.anim.translate);
                    break;
                case R.id.btn_set:

                    anim = AnimationUtils.loadAnimation(context,R.anim.anim_set);

                    break;
                default:
                    Intent intent = new Intent();
                    intent.setClass(context,SecondActivity.class);
                    startActivity(intent);

                    overridePendingTransition(R.anim.scale,R.anim.translate);
                    return;
            }

            anim.setAnimationListener(al);
            ivTt.startAnimation(anim);
        }
    };

    Animation.AnimationListener al = new Animation.AnimationListener() {

        // 动画开始时被调用的方法
        @Override
        public void onAnimationStart(Animation animation) {

            Log.d(TAG, "onAnimationStart() called with: animation = [" + animation + "]");


        }

        // 动画结束
        @Override
        public void onAnimationEnd(Animation animation) {

            Log.d(TAG, "onAnimationEnd() called with: animation = [" + animation + "]");
        }

        // 动画重复
        @Override
        public void onAnimationRepeat(Animation animation) {
            Log.d(TAG, "onAnimationRepeat() called with: animation = [" + animation + "]");
        }
    };

}
