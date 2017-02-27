package android.wjf.android06.feicuiedu.com.news.ui;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.news.R;
import android.wjf.android06.feicuiedu.com.news.ui.base.MyBaseActivity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


/**
 * 主界面
 **/
public class ActivityMain extends MyBaseActivity {

    private TextView textView_title;

    private Fragment fragmentMenu, fragmentMenuRight;
    private Fragment fragmentMain;
    public static SlidingMenu slidingMenu;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_main);
        textView_title = (TextView) findViewById(R.id.textView1);
        fragmentMenu = new FragmentMenu();
        fragmentMenuRight = new FragmentMenuRight();
        /*初始化SlidingMenu方法*/ /*初始化FragmentMain方法*/
    }


}
