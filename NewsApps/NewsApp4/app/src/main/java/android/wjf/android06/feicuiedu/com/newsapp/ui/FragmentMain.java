package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.newsapp.R;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by ad06-wjf on 2016/11/30.
 */
@ContentView(R.layout.activity_main)
public class FragmentMain extends AppCompatActivity {

    private Context context;

    private SlidingMenu menu;

    @ViewInject(R.id.textView_main)
    private TextView textViewMain;

    //两边按钮
    @ViewInject(R.id.imageView_set)
    private ImageView imageViewSet;
    @ViewInject(R.id.imageView_user)
    private ImageView imageViewUser;

    private Fragment leftMenuFragment;
    private Fragment rightMenuFragment;


    private FragmentNews fn;
    private FragmentRead fr;
    private FragmentLogin fl;

    private FragmentManager fm;

    String title = "新闻";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        context = this;


        fm = this.getFragmentManager();

        initFragment();
        imageViewSet.setOnClickListener(oclIV);
        imageViewUser.setOnClickListener(oclIV);

        // title
        Log.d("1111", "onCreate: "+title);

        showFragment();


    }

    View.OnClickListener oclIV = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.imageView_set:
                    menu.showMenu();
                    break;
                case R.id.imageView_user:
                    menu.showSecondaryMenu();
                    break;
            }
        }
    };


    private void initFragment() {
        menu = new SlidingMenu(this);

        // 设置动画
        menu.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
                // 放缩动画
                float scale = (float) (percentOpen * 0.25 + 0.75);
                canvas.scale(scale, scale, canvas.getWidth() / 2, canvas.getHeight() / 2);
            }
        });

        // 设置侧滑菜单的位置，可选值LEFT , RIGHT , LEFT_RIGHT （两边都有菜单时设置）
        menu.setMode(SlidingMenu.LEFT_RIGHT);

        // 设置触摸屏幕的模式 可以选择全屏划出，或者是边缘划出，或者是不可划出,这里为全屏划出
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);

        // 设置渐入渐出效果的值 范围是0-1.0f,设置的越大，则在侧滑栏刚划出的时候， 颜色就越暗。1.0f的时候，颜色为全黑刚划出的时候
        menu.setFadeDegree(0.35f);

        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        // 把滑动菜单添加进所有的Activity中，可选值SLIDING_CONTENT ， SLIDING_WINDOW
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

        //为左侧滑菜单设置布局
        menu.setMenu(R.layout.frame_left);

        menu.setSecondaryMenu(R.layout.frame_right);

        if (leftMenuFragment == null) {
            leftMenuFragment = new LeftFragment(menu, new LeftFragment.IResponse2() {
                @Override
                public void onReturn(String result) {
                    title = result;
                    Log.d("2222", "onCreate: "+title);
                    showFragment();
                }
            });
        }

        getFragmentManager().beginTransaction().replace(R.id.frame_left, leftMenuFragment).commit();

        if (rightMenuFragment == null) {
            rightMenuFragment = new RightFragment(menu, new RightFragment.IResponse3() {
                @Override
                public void onReturn(String result) {

                    title = result;
                    Log.d("3333", "onCreate: "+title);
                    showFragment();
                }
            });
        }

        getFragmentManager().beginTransaction().replace(R.id.frame_right, rightMenuFragment).commit();
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fn != null) {
            fragmentTransaction.hide(fn);
        }
        if (fr != null) {
            fragmentTransaction.hide(fr);
        }
        if (fl != null) {
            fragmentTransaction.hide(fl);
        }

    }

    private void showFragment() {

        FragmentTransaction ft = fm.beginTransaction();
        hideAllFragment(ft);

        if (title.equals("新闻")) {
            textViewMain.setText("资讯");
            if (fn == null) {
                fn = new FragmentNews();
                ft.add(R.id.layout_content, fn);
            } else {
                ft.show(fn);
            }
        } else if (title.equals("收藏")) {
            textViewMain.setText("收藏");
            if (fr == null) {
                fr = new FragmentRead();
                ft.add(R.id.layout_content, fr);
            } else {
                ft.show(fr);
            }
        }else if (title.equals("用户登录")) {
            textViewMain.setText("用户登录");
            if (fl == null) {
                fl = new FragmentLogin();
                ft.add(R.id.layout_content, fl);
            } else {
                ft.show(fl);
            }
        }else if (title.equals("分享")) {
            textViewMain.setText("分享");


        }
        ft.commit();
    }


}

