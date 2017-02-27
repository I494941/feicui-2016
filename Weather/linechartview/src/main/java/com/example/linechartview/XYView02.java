package com.example.linechartview;

/**
 * Created by wangjinfei on 16/12/25.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by ENZ on 2016/11/25.
 * 绘制自定义view折线图
 * 第一步：绘制X和Y轴,那么我们需要什么准备呢？
 */

public class XYView02 extends View {

    private int viewSize;//获取空间的尺寸，也就是我们布局的尺寸大小（不知道理解的是否正确）
    private Paint linePaint;// 线条画笔和点画笔

    private Path mPath;// 路径对象
    private TextPaint mTextPaint;// 文字画笔

    private List<PointF> pointFs = new ArrayList<>();// 数据列表
    private float[] rulerX, rulerY;// xy轴向刻度

    //上下左右坐标点
    private float lift ;
    private  float top ;
    private  float right ;
    private float buttom ;

    //Y轴文字坐标点
    private float PathY_X ;
    private float PathY_Y ;
    //X轴文字坐标点
    private float PathX_X ;
    private float PathX_Y ;

    private float maxX;//x轴最大值
    private float maxY;//Y轴最大值

    private float spaceX, spaceY;// 刻度间隔

    public XYView02(Context context, AttributeSet attrs) {
        super(context, attrs);
        //第一步，初始化对象
        linePaint = new Paint();
        linePaint.setColor(Color.YELLOW);//线条的颜色
        linePaint.setStrokeWidth(8);//线条的宽度
        linePaint.setAntiAlias(true);//取消锯齿
        linePaint.setStyle(Paint.Style.STROKE);//粗线


        //初始化Path
        mPath = new Path();

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.LINEAR_TEXT_FLAG);
        mTextPaint.setColor(Color.WHITE);

        //模拟数据
        initData();
    }

    public XYView02(Context context) {
        super(context);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 在我们没学习测量控件之前强制宽高一致
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //第二步骤，我们在这里获取每个用到的坐标点和尺寸

        viewSize = w;//获取空间的尺寸，
        Log.i("Text","viewSize:"+viewSize);

        //这个是我们上下左右需要用到的坐标点
        lift = viewSize*(1/16f);
        top = viewSize*(1/16f);
        right = viewSize*(15/16f);
        buttom = viewSize*(8/16f);

        //下面是绘制X,Y轴提示文字
        /*
        * Y轴(PathY_X,PathY_Y)
        * */
        PathY_X =  viewSize*2/16;
        PathY_Y =  viewSize*1/16;

        /*
        * X轴(PathX_X,PathX_Y)
        * */
        PathX_X =  viewSize*15/16f;
        PathX_Y =  viewSize*9/16f;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 锁定画布
        canvas.save();


        //定义一个绘制X,Y轴的方法
        drawXY(canvas);


        //绘制X和Y轴上的提示文字
        drawXYelement(canvas);


    }
    private void initData() {
        Random random = new Random();
        pointFs = new ArrayList<PointF>();
        for (int i = 0; i < 8; i++) {
            PointF pointF = new PointF();

            pointF.x = (float) (random.nextInt(100) * i);
            pointF.y = (float) (random.nextInt(100) * i);

            pointFs.add(pointF);
        }
    }
    private void drawXY(Canvas canvas) {
        /*
        * 第三步，我们来通过viewSize尺寸来获取三个坐标点
        * 第一个（X,Y）--(lift,top)
        * 第二个（X,Y）--(lift,button)
        * 第三个个（X,Y）--(right,buttom)
        * */
        mPath.moveTo(lift, top);
        mPath.lineTo(lift, buttom);
        mPath.lineTo(right,buttom);

        //使用Path链接这三个坐标
        canvas.drawPath(mPath,linePaint);

        //----------------------------我们在这里添加一个绘制网格的方法----------------------------------------
        drawLines(canvas);
        // 释放画布
        canvas.restore();
    }

    private void drawLines(Canvas canvas) {

        // 重置线条画笔，因为是细线，所有我这里设置了2。
        linePaint.setStrokeWidth(2);

        // 假如我们有八条数据
        int count = pointFs.size();

        // 计算横纵坐标刻度间隔
        spaceY =(buttom - top) / count;
        spaceX =(right - lift) / count;

        Log.i("Text","spaceY:--"+spaceY);
        Log.i("Text","spaceX:--"+spaceX);
        // 计算除数的值为数据长度减一，8个数据，7条线。
        int divisor = count - 1;
        Log.i("Text","divisor:--"+divisor);

        // 计算横轴数据最大值
        maxX = 0;
        for (int i = 0; i < count; i++) {
            if (maxX < pointFs.get(i).x) {
                maxX = pointFs.get(i).x;//X轴最大坐标

            }
        }
        Log.i("Text","maxX:--"+maxX);
        // 计算横轴最近的能被count整除的值
        int remainderX = ((int) maxX) % divisor;
        maxX = remainderX == 0 ? ((int) maxX) : divisor - remainderX + ((int) maxX);


        // 计算纵轴数据最大值
        maxY = 0;
        for (int i = 0; i < count; i++) {
            if (maxY < pointFs.get(i).y) {
                maxY = pointFs.get(i).y;
            }
        }
        Log.i("Text","maxY:--"+maxY);
        // 计算纵轴最近的能被count整除的值
        int remainderY = ((int) maxY) % divisor;
        Log.i("Text","remainderY:--"+remainderY);

        if(remainderY == 0&&maxY==0){
            maxY=0;
        }else {
            maxY=divisor - remainderY + ((int) maxY);
            Log.i("Text","maxY11111111111:--"+maxY);
        }
//
//        // 生成横轴刻度值
//        rulerX = new float[count];
//        for (int i = 0; i < count; i++) {
//            rulerX[i] = maxX / divisor * i;
//        }
//        Log.i("Text","rulerX:--"+rulerX);
//
//        // 生成纵轴刻度值
//        rulerY = new float[count];
//        for (int i = 0; i < count; i++) {
//            rulerY[i] = maxY / divisor * i;
//        }
//        Log.i("Text","rulerY:--"+rulerY);

        // 锁定画布并设置画布透明度为75%
        int sc = canvas.saveLayerAlpha(0, 0, canvas.getWidth(), canvas.getHeight(), 75, Canvas.ALL_SAVE_FLAG);

        // 绘制横纵线段
        for (float y = buttom - spaceY; y >  top; y -= spaceY) {
            Log.i("Text","y"+y);

            for (float x =  lift; x < right; x += spaceX) {
                Log.i("Text","x"+x);
                /*
                 * 绘制纵向线段
                 */
                if (y == top + spaceY) {
                    canvas.drawLine(x, y, x, y + spaceY * (count - 1), linePaint);
                }

                /*
                 * 绘制横向线段
                 */
                if (x == right - spaceX) {
                    canvas.drawLine(x, y, x - spaceX * (count - 1), y, linePaint);
                }
            }
        }

        // 还原画布
        canvas.restoreToCount(sc);

    }



    private void drawXYelement(Canvas canvas) {
        // 锁定画布
        canvas.save();
        mTextPaint.setTextSize(36);//文字大小
  /*
        * Y轴文字提示
        * drawText(String ,x,y,TextPaint)
        * (lift,top)
        * */
        mTextPaint.setTextAlign(Paint.Align.LEFT);//左对齐
        canvas.drawText("Y",lift+20,top,mTextPaint);

        /*
        * X轴文字提示
        * drawText(String ,right,buttom,TextPaint)
        * */
        mTextPaint.setTextAlign(Paint.Align.RIGHT);//右对齐
        canvas.drawText("X",right,buttom+50,mTextPaint);
        // 释放画布
        canvas.restore();
    }

}