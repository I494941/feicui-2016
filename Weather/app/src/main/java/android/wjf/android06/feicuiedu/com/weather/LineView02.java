
package android.wjf.android06.feicuiedu.com.weather;
/**
 * Created by wangjinfei on 16/12/25.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ENZ on 2016/11/25.
 */

public class LineView02 extends View {

    private Context context;

    private int viewSize;//获取空间的尺寸，也就是我们布局的尺寸大小（不知道理解的是否正确）
    private Paint linePaint;// 线条画笔和点画笔

    private Canvas mCanvas;

    private Path mPath;// 路径对象
    private TextPaint mTextPaint;// 文字画笔

    private List<PointF> pointFs = new ArrayList<>();// 数据列表
    private float[] rulerX, rulerY;// xy轴向刻度

    //上下左右坐标点
    private float left;
    private float top;
    private float right;
    private float buttom;

    //Y轴文字坐标点
    private float PathY_X;
    private float PathY_Y;
    //X轴文字坐标点
    private float PathX_X;
    private float PathX_Y;

    /*
   * 绘制X和Y轴对应的文字
   * */
    private String[] index_x = {"周一", "周二", "周三", "周四", "周五", "周六", "周日", ""};
    private int[] index_y = {1, 2, 3, 4, 5, 6, 7, 8};

    private String signX = "X";// X轴提示
    private String signY = "Y";// Y轴提示

    public LineView02(Context context) {
        super(context);
    }

    public LineView02(Context context, AttributeSet attrs) {
        super(context, attrs);



        //第一步，初始化对象
        linePaint = new Paint();
        linePaint.setColor(Color.BLACK);//线条的颜色
        linePaint.setStrokeWidth(8);//线条的宽度
        linePaint.setAntiAlias(true);//取消锯齿
        linePaint.setStyle(Paint.Style.STROKE);//粗线


        //初始化Path
        mPath = new Path();

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.LINEAR_TEXT_FLAG);
        mTextPaint.setColor(Color.RED);

        mCanvas = new Canvas();

        //模拟数据
        // initData();
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

        Log.i("Text", "viewSize:" + viewSize);


        //这个是我们上下左右需要用到的坐标点
        left = viewSize * (2 / 16f);
        top = viewSize * (2 / 16f);
        right = viewSize * (15 / 16f);
        buttom = viewSize * (8 / 16f);

        //下面是绘制X,Y轴提示文字
        /*
        * Y轴(PathY_X,PathY_Y)
        * */
        PathY_X = viewSize * 2 / 16;
        PathY_Y = viewSize * 1 / 16;

        /*
        * X轴(PathX_X,PathX_Y)
        * */
        PathX_X = viewSize * 15 / 16f;
        PathX_Y = viewSize * 9 / 16f;

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

        //最后绘制我们的点和线
        drawbitmaps(canvas);

    }


    private void initData() {
        pointFs = new ArrayList<PointF>();
        for (int i = 0; i < 8; i++) {
            PointF pointF = new PointF();

            pointF.x = (float) i;
            pointF.y = (float) (index_y[i]);

            pointFs.add(pointF);
        }
    }

    private void drawXY(Canvas canvas) {

         /*
        * 第三步，我们来通过viewSize尺寸来获取三个坐标点
        * 第一个（X,Y）--(lift,top)
        * 第二个（X,Y）--(lift,button)
        * 第三个（X,Y）--(right,buttom)
        * */
        mPath.moveTo(left, top);
        mPath.lineTo(left, buttom);
        mPath.lineTo(right, buttom);

        //使用Path链接这三个坐标
        canvas.drawPath(mPath, linePaint);

        // 画箭头Y
        canvas.drawLine(viewSize * (3 / 32f), viewSize * (5 / 32f), viewSize * (2 / 16f), viewSize * (2 / 16f), linePaint);
        canvas.drawLine(viewSize * (5 / 32f), viewSize * (5 / 32f), viewSize * (2 / 16f), viewSize * (2 / 16f), linePaint);

        // 画箭头X
        canvas.drawLine(viewSize * (29 / 32f), viewSize * (15 / 32f), viewSize * (15 / 16f), viewSize * (8 / 16f), linePaint);
        canvas.drawLine(viewSize * (15 / 16f), viewSize * (8 / 16f), viewSize * (29 / 32f), viewSize * (17 / 32f), linePaint);

        // 画线  零下
        canvas.drawLine(left, buttom, left, viewSize * (14 / 16f), linePaint);

        //----------------------------我们在这里添加一个绘制网格的方法----------------------------------------
        drawLines(canvas);
        // 释放画布
        canvas.restore();
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
        canvas.drawText(signY, PathY_X, PathY_Y, mTextPaint);

        /*
        * X轴文字提示
        * drawText(String ,right,buttom,TextPaint)
        * */
        mTextPaint.setTextAlign(Paint.Align.RIGHT);//右对齐
        canvas.drawText(signX, PathX_X + viewSize * (1 / 16f), PathX_Y, mTextPaint);

        /*
        * X轴刻度
        * drawText(String ,right,buttom,TextPaint)
        * */
        mTextPaint.setTextSize(20);//文字大小
        mTextPaint.setColor(Color.BLUE);
        for (int i = 0; i < 7; i++) {
            canvas.drawText(index_x[i], left + viewSize * (1 / 16f) + viewSize * (2 / 16f) * i, buttom + viewSize * (1 / 32f), mTextPaint);
        }

        /*
        * Y轴刻度
        * drawText(String ,right,buttom,TextPaint)
        * */
        for (int i = 0; i < 6; i++) {
            canvas.drawText(10 * i + "", left - viewSize * (1 / 32f), buttom - viewSize * (1 / 16f) * i, mTextPaint);
        }
        for (int i = 1; i < 6; i++) {
            canvas.drawText(-10 * i + "", left - viewSize * (1 / 32f), buttom + viewSize * (1 / 16f) * i, mTextPaint);
        }
        // 释放画布
        canvas.restore();
    }

    private void drawbitmaps(Canvas canvas) {

        Bitmap mBitmap = Bitmap.createBitmap((int) (viewSize * (12 / 16f)), (int) (viewSize * (10 / 16f)), Bitmap.Config.ARGB_8888);

        mCanvas.setBitmap(mBitmap);

        /*
        * 为画布填充一个半透明的红色
        * drawARGB(a,r,g,b)
        * a:透明度
        * r:红色
        * g:绿色
        * b:蓝色
        * */
        mCanvas.drawARGB(55, 255, 0, 0);

        // 重置曲线
        mPath.reset();
        // 将mBitmap绘制到原来的canvas
        canvas.drawBitmap(mBitmap, left, (viewSize * (3 / 16f)), null);

        //绘制我们的坐标点
        drawText(canvas);
    }

    private void drawLines(Canvas canvas) {

        // 重置线条画笔，因为是细线，所有我这里设置了2。

        Paint linePaint2 = new Paint();

        linePaint2.setColor(Color.RED);//线条的颜色
        linePaint2.setStrokeWidth(2);//线条的宽度
        linePaint2.setAntiAlias(true);//取消锯齿
        linePaint2.setStyle(Paint.Style.STROKE);//粗线

        for (int i = 1; i < 6; i++) {
            canvas.drawLine(left, buttom - viewSize * (1 / 16f) * i, right - viewSize * (1 / 16f), buttom - viewSize * (1 / 16f) * i, linePaint2);
        }
        for (int i = 1; i < 6; i++) {
            canvas.drawLine(left, buttom + viewSize * (1 / 16f) * i, right - viewSize * (1 / 16f), buttom + viewSize * (1 / 16f) * i, linePaint2);
        }
        for (int i = 1; i < 7; i++) {
            canvas.drawLine(left + viewSize * (2 / 16f) * i, viewSize * (3 / 16f), left + viewSize * (2 / 16f) * i, viewSize * (13 / 16f), linePaint2);
        }

        linePaint2.setColor(Color.BLUE);
        for (int i = 1; i < 6; i++) {
            canvas.drawLine(left, buttom - viewSize * (1 / 16f) * i, left + viewSize * (1 / 32f), buttom - viewSize * (1 / 16f) * i, linePaint2);
        }
        for (int i = 1; i < 6; i++) {
            canvas.drawLine(left, buttom + viewSize * (1 / 16f) * i, left + viewSize * (1 / 32f), buttom + viewSize * (1 / 16f) * i, linePaint2);
        }
        for (int i = 1; i < 7; i++) {
            canvas.drawLine(left + viewSize * (2 / 16f) * i, viewSize * (15 / 32f), left + viewSize * (2 / 16f) * i, viewSize * (17 / 32f), linePaint2);
        }

    }
    private void drawText(Canvas canvas) {
        Paint pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        pointPaint.setStyle(Paint.Style.FILL);//焦点的类型
        pointPaint.setColor(Color.WHITE);//焦点的颜色

        if (pointFs.size() == 0) {
            // Toast.makeText(context, "暂无折现数据", Toast.LENGTH_SHORT).show();
        } else {
                /*
         * 生成Path和绘制Point
         */
            for (int i = 0; i < pointFs.size(); i++) {
                // 计算x坐标
                float x = mCanvas.getWidth() / 6 * pointFs.get(i).x;
                // 计算y坐标
                float y = mCanvas.getHeight() / 101 * (pointFs.get(i).y * 2 + 101) / 2;
                y = mCanvas.getHeight() - y;

                // 绘制小点点
                mCanvas.drawCircle(x, y, 6, pointPaint);

            /*
             * 如果是第一个点则将其设置为Path的起点
             */
                if (i == 0) {
                    mPath.moveTo(x, y);
                }

                // 连接各点
                mPath.lineTo(x, y);
            }

            Paint linePaint3 = new Paint();

            linePaint3.setColor(Color.BLUE);//线条的颜色
            linePaint3.setStrokeWidth(4);//线条的宽度
            linePaint3.setAntiAlias(true);//取消锯齿
            linePaint3.setStyle(Paint.Style.STROKE);//粗线

            // 设置PathEffect
            linePaint3.setPathEffect(new CornerPathEffect(10));


            // 将Path绘制到我们自定的Canvas上
            mCanvas.drawPath(mPath, linePaint3);
        }
    }

    public synchronized void setData(List<PointF> pointFs, String signX, String signY, Activity activity) {
        /*
         * 数据为空直接GG
         */
        if (null == pointFs || pointFs.size() == 0)
            throw new IllegalArgumentException("No data to display !");

        /*
         * 控制数据长度不超过10个
         * 对于折线图来说数据太多就没必要用折线图表示了而是使用散点图
         */
        if (pointFs.size() > 10)
            throw new IllegalArgumentException("The data is too long to display !");

        // 设置数据并重绘视图
        this.pointFs = pointFs;
        this.context = activity;
        this.signX = signX;
        this.signY = signY;

        invalidate();
    }

}