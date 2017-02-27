package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R;

/**
 * Created by ad06-wjf on 2016/11/10.
 */

public class ClearArcView extends View {

    private Paint paint = new Paint();
    private RectF oval;
    private final int START_ANGLE = -90;
    private int sweepAngle = 0;
    private int state = 0; // 0: 回退 ；1:前进
    private int arcColor = 0xFFFF8C00;
    private int[] back = new int[] { -6, -6, -10, -10, -10, -12 };
    private int backIndex;

    private int[] goon = new int[] { 12, 12, 12, 12, 10, 10, 10, 8, 8, 8,6 };
    private int goonIndex;
    private boolean isRuning = false;
    public ClearArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //设置初始扫描角度
        setAngle(360);
        //获取一键清理圆环颜色
        arcColor = context.getResources().getColor(R.color.clear_arc_color);
    }

    public void setAngle(final int angle) {
        sweepAngle = angle;
        postInvalidate();
        isRuning = false;
    }

    // 设置角度，且带动画
    public void setAngleWithAnim(final int angle) {
        if (isRuning) {
            return;
        }
        isRuning = true;
        state = 0; // 回退
        final Timer timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                switch (state) {
                    case 0:
                        sweepAngle += back[backIndex++];
                        if (backIndex >= back.length) {
                            backIndex = back.length - 1;
                        }
                        postInvalidate();
                        if (sweepAngle <= 0) {
                            sweepAngle = 0;
                            state = 1;
                            backIndex = 0;
                        }
                        break;
                    case 1:
                        sweepAngle += goon[goonIndex++];
                        if (goonIndex >= goon.length) {
                            goonIndex = goon.length - 1;
                        }
                        postInvalidate();
                        if (sweepAngle >= angle) {
                            sweepAngle = angle;
                            timer.cancel();
                            goonIndex = 0;
                            isRuning = false;
                        }
                        break;
                }
            }
        };
        timer.schedule(timerTask, 24, 24);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        // int viewWidth = getWidth();
        // int viewHeight = getHeight();
        //根据父控件传入的宽高规范，获取设定的控件的宽高
        int viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        int viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        oval = new RectF(0, 0, viewWidth, viewHeight); // 旋转圆形大小
        setMeasuredDimension(viewWidth, viewHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(arcColor);
        paint.setAntiAlias(true);
        canvas.drawArc(oval, START_ANGLE, sweepAngle, true, paint); // 会旋转的圆形
    }


}
