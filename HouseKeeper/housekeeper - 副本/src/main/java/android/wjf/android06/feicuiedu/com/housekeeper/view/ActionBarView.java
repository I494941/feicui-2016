package android.wjf.android06.feicuiedu.com.housekeeper.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.housekeeper.R;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

public class ActionBarView extends LinearLayout {

    private ImageView iv_actionbar_left;//左边按钮
    private ImageView iv_actionbar_right;//右边按钮
    private TextView tv_actionbar_title;//中间文本

    public ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs); // TODO Auto-generated constructor stub
        inflate(context, R.layout.activity_actionbar, this);
        tv_actionbar_title = (TextView) findViewById(R.id.tv_title);
        iv_actionbar_left = (ImageView) findViewById(R.id.iv_left);
        iv_actionbar_right = (ImageView) findViewById(R.id.iv_right);
    }

    /**
     * 初始化ActionBar * * @param title * 中间标题文字 * @param leftResID * 左边图像资源ID(无图像时传-1) * @param rightResID右边图像资源ID * (无图像时传-1) * @param listener * 左右两边图标监听
     */
    public void initActionBar(String title, int leftResID, int rightResID, OnClickListener listener) {
        tv_actionbar_title.setText(title);
        if (leftResID == -1) {
            iv_actionbar_left.setVisibility(View.INVISIBLE);
        } else {
            iv_actionbar_left.setImageResource(leftResID);
            iv_actionbar_left.setOnClickListener(listener);
        }
        if (rightResID == -1) {
            iv_actionbar_right.setVisibility(View.INVISIBLE);
        } else {
            iv_actionbar_right.setImageResource(rightResID);
            iv_actionbar_right.setOnClickListener(listener);
        }
    }

}
