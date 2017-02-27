package com.example.viewpagerpractice2;


import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/*
 * 自定义viewpager实现动画切换效果：
 *
 * 1、拿到当前切换的两个view
 *
 * 2、一个动画的梯度值
 */
public class MyViewPager extends ViewPager {


    private View mLeft;
    private View mRight;

    private float mTrans;
    private float mScale;

    private static final float MIN_SCALE = 0.6f;
    private Map<Integer, View> mChildren = new HashMap<>();

    /*
     * 两个构造方法
     */
    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewPager(Context context) {
        super(context);
    }



    /**
     * 重写de方法
     */
    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {


        mLeft = mChildren.get(position);
        mRight = mChildren.get(position + 1);

        animStack(mLeft, mRight, offset, offsetPixels);// 创建动画效果

        super.onPageScrolled(position, offset, offsetPixels);
    }

    private void animStack(View left, View right, float offset, int offsetPixels) {
        if (right != null) {

            // 从0-1页，offset:0`1
            mScale = (1 - MIN_SCALE) * offset + MIN_SCALE;

            mTrans = -getWidth() - getPageMargin() + offsetPixels;

            ViewHelper.setScaleX(right, mScale);
            ViewHelper.setScaleY(right, mScale);

            ViewHelper.setTranslationX(right, mTrans);
        }
        if (left != null) {
            left.bringToFront();
        }
    }
}