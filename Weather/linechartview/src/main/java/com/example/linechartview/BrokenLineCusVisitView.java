package com.example.linechartview;

/**
 * Created by wangjinfei on 16/12/25.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2015/10/13.
 */
public class BrokenLineCusVisitView extends View {
    private int width;
    private int heigh;

    //网格的宽度与高度
    private int gridspace_width;
    private int gridspace_heigh;
    //底部空白的高度
    private int brokenline_bottom;


    //灰色背景的画笔
    private Paint mPaint_bg;
    //灰色网格的画笔
    private Paint mPaint_gridline;
    //文本数据的画笔
    private Paint mPaint_text;

    //折线圆点的蓝色背景
    private Paint mPaint_point_bg;
    //折线圆点的白色表面
    private Paint mPaint_point_sur;
    //阴影路径的画笔
    private Paint mPaint_path;
    //折线的画笔
    private Paint mPaint_brokenline;
    //路径
    private Path mpath=new Path();
    //客户拜访的折线（BrokenLineCusVisit）数据
    private List<BrokenLineCusVisit> mdata;

    public BrokenLineCusVisitView(Context context) {
        super(context);
    }

    public BrokenLineCusVisitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inite(context);
    }

    private void inite(Context context) {

        mPaint_bg=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint_bg.setColor(Color.argb(0xff,0xef,0xef,0xef));

        mPaint_gridline=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint_gridline.setColor(Color.argb(0xff,0xce,0xCB,0xce));

        mPaint_brokenline=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint_brokenline.setColor(Color.argb(0xff,0x91,0xC8,0xD6));
        mPaint_brokenline.setTextSize(18);
        mPaint_brokenline.setTextAlign(Paint.Align.CENTER);

        mPaint_point_bg=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint_point_bg.setColor(Color.argb(0xff, 0x91, 0xC8, 0xD6));
        //注意path的画笔的透明度已经改变了
        mPaint_path=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint_path.setColor(Color.argb(0x33,0x91,0xC8,0xD6));


        mPaint_point_sur=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint_point_sur.setColor(Color.WHITE);


        mPaint_text=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint_text.setColor(Color.BLACK);
        mPaint_text.setTextAlign(Paint.Align.CENTER);

        invalidate();
    }
    //data的set/get方法，用于设置数据
    public List<BrokenLineCusVisit> getMdata() {
        return mdata;
    }

    public void setMdata(List<BrokenLineCusVisit> mdata) {
        this.mdata = mdata;
        requestLayout();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        //绘制白色背景
        canvas.drawColor(Color.WHITE);
        //绘制灰色矩形区域
        canvas.drawRect(10,0,width,heigh-brokenline_bottom,mPaint_bg);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        gridspace_width= 50;
        if(mdata.size()==0){
            width=getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        }
        else{
            //根据数据的条数设置宽度
            width=gridspace_width*mdata.size()+10;
        }

        heigh=getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        brokenline_bottom=50;

        Log.d("bottm",""+brokenline_bottom);
        gridspace_heigh=(heigh-brokenline_bottom)/4;
        setMeasuredDimension(width, heigh);
    }
}