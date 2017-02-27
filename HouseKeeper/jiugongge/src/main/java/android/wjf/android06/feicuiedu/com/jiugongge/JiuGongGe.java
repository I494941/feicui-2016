package android.wjf.android06.feicuiedu.com.jiugongge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ad06-wjf on 2016/11/23.
 */

public class JiuGongGe extends View {

    public JiuGongGe(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public JiuGongGe(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public JiuGongGe(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        // 设置画布的背景颜色
        canvas.drawColor(Color.WHITE);
        /**
         * 定义矩形为实心
         */
        // 定义画笔1
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        // 设置画笔的颜色
        paint.setColor(Color.RED);
        // 设置paint的外框宽度
        paint.setStrokeWidth(2);

        // 画正放形No.1-1
        canvas.drawRect(50, 50, 150, 150, paint);

        // 设置画笔的颜色
        paint.setColor(Color.BLACK);

        // 画正放形No.1-2
        canvas.drawRect(150, 50, 250, 150, paint);

        // 设置画笔的颜色
        paint.setColor(Color.BLUE);

        // 画正放形No.1-3
        canvas.drawRect(250, 50, 350, 150, paint);

        // 设置画笔的颜色
        paint.setColor(Color.GRAY);

        // 画正放形No.2-1
        canvas.drawRect(50, 150, 150, 250, paint);

        // 设置画笔的颜色
        paint.setColor(Color.CYAN);

        // 画正放形No.2-2
        canvas.drawRect(150, 150, 250, 250, paint);

        // 设置画笔的颜色
        paint.setColor(Color.DKGRAY);

        // 画正放形No.2-3
        canvas.drawRect(250, 150, 350, 250, paint);

        // 设置画笔的颜色
        paint.setColor(Color.GREEN);

        // 画正放形No.3-1
        canvas.drawRect(50, 250, 150, 350, paint);

        // 设置画笔的颜色
        paint.setColor(Color.LTGRAY);

        // 画正放形No.3-2
        canvas.drawRect(150, 250, 250, 350, paint);

        // 设置画笔的颜色
        paint.setColor(Color.YELLOW);

        // 画正放形No.3-3
        canvas.drawRect(250, 250, 350, 350, paint);

    }
}


