package android.wjf.android06.feicuiedu.com.housekeeper.base;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.housekeeper.R;
import android.wjf.android06.feicuiedu.com.housekeeper.utils.LogUtil;

/**
 * 带ActiooonBar控件数据初始化方法及onClick监听的基础Activity
 */
public abstract class BaseActionbarActivity extends BaseActivity {

    public static final int NULL_ID = -1;

    /**
     * 设置ActionBar控件上的数据
     *
     * @param resIdTitle 中间主标题文本id,没有标题时可使用{@link #NULL_ID}
     * @param resIdLeft  * 左侧图标资源id,没有图标时可使用{@link #NULL_ID}
     * @param resIdRight * 右侧图标资源id,没有图标时可使用{@link #NULL_ID}
     */
    public void setActionBar(int resIdTitle, int resIdLeft, int resIdRight) {
        try {
            TextView tv_action_title = (TextView) findViewById(R.id.tv_title);
            ImageView iv_action_left = (ImageView) findViewById(R.id.iv_left);
            ImageView iv_action_right = (ImageView) findViewById(R.id.iv_right);
            if (resIdLeft != NULL_ID) {
                iv_action_left.setImageResource(resIdLeft);
            } else {
                iv_action_left.setVisibility(View.INVISIBLE);
            }
            if (resIdRight != NULL_ID) {

                iv_action_right.setImageResource(resIdRight);
            } else {
                iv_action_right.setVisibility(View.INVISIBLE);
            }
            if (resIdTitle != NULL_ID) {
                tv_action_title.setText(resIdTitle);
            }
        } catch (Exception e) {
            LogUtil.w("BaseActionbarActivity", "ActionBar有异常,是否当前页面并没有includle==> include_actionbar.xml布局?");
        }
    }
}