package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.wjf.android06.feicuiedu.com.newsapp.R;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by ad06-wjf on 2016/12/2.
 */
@ContentView(R.layout.activity_main)
public class ActivityRead extends AppCompatActivity {

    //两边按钮
    @ViewInject(R.id.imageView_set)
    private ImageView imageViewSet;
    @ViewInject(R.id.imageView_user)
    private ImageView imageViewUser;

    private SlidingMenu menu;

    private Fragment leftMenuFragment;
    private Fragment rightMenuFragment;

    private Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        context = this;
        leftMenuFragment = new LeftFragment();
        rightMenuFragment = new RightFragment();

        initFragment();

        imageViewSet.setOnClickListener(oclIV);
        imageViewUser.setOnClickListener(oclIV);



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

        getFragmentManager().beginTransaction().replace(R.id.frame_left, leftMenuFragment).commit();

        getFragmentManager().beginTransaction().replace(R.id.frame_right, rightMenuFragment).commit();
    }

}
