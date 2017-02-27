package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.wjf.android06.feicuiedu.com.newsapp.R;
import android.wjf.android06.feicuiedu.com.newsapp.net.NewsRequestNet;
import android.wjf.android06.feicuiedu.com.newsapp.net.RequestNet;
import android.wjf.android06.feicuiedu.com.newsapp.ui.adapter.NewsAdapter;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ad06-wjf on 2016/11/30.
 */
@ContentView(R.layout.activity_main)
public class FragmentMain extends AppCompatActivity {

    private static final String TAG = "FragmentMain";

    private Context context;

    //动态加载Button
    @ViewInject(R.id.view)
    private LinearLayout ll;

   /* //新闻分类
    @ViewInject(R.id.btn_main_military)
    private Button btnMilitary;
    @ViewInject(R.id.btn_main_society)
    private Button btnSociety;
    @ViewInject(R.id.btn_main_shares)
    private Button btnShares;
    @ViewInject(R.id.btn_main_fund)
    private Button btnFund;
    @ViewInject(R.id.btn_main_phone)
    private Button btnPhone;
    @ViewInject(R.id.btn_main_premiership)
    private Button btnPremiership;
    @ViewInject(R.id.btn_main_nba)
    private Button btnNBA;*/

    @ViewInject(R.id.lv_main)
    private ListView lvMain;

    private SlidingMenu menu;

    //两边按钮
    @ViewInject(R.id.imageView_set)
    private ImageView imageViewSet;
    @ViewInject(R.id.imageView_user)
    private ImageView imageViewUser;

    private Fragment leftMenuFragment;
    private Fragment rightMenuFragment;

    private List<Map<String, String>> newsList;
    private Map<String, String> subGroupMap = new LinkedHashMap<>();
    String subid = "";

    NewsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        context = this;

        if(leftMenuFragment == null){
            leftMenuFragment = new LeftFragment();
        }
        if(rightMenuFragment == null){
            rightMenuFragment = new RightFragment();
        }

        initFragment();
        imageViewSet.setOnClickListener(oclIV);
        imageViewUser.setOnClickListener(oclIV);

        new RequestNet().requestNet(new RequestNet.IResponse() {
            @Override
            public void onReturn(Map<String, String> map) {

                subGroupMap = map;

                for (Map.Entry<String, String> entry : subGroupMap.entrySet()) {
                    subid = entry.getKey();
                    if (subid != null) {
                        break;
                    }
                }
                initButton();
                Log.d(TAG, "onReturn: ><><" + subid);
                newsList = new ArrayList<>();
                adapter = new NewsAdapter(newsList, context);
                new NewsRequestNet().NewsRequestNet(subid, newsList, adapter);
                lvMain.setAdapter(adapter);

            }
        });



    }

    public void initButton() {

        for (Map.Entry<String, String> entry : subGroupMap.entrySet()) {
            //设置文本的样式
            Button btn = new Button(getApplicationContext());
            btn.setText(entry.getValue());
            btn.setId(Integer.parseInt(entry.getKey()));
            btn.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT));
            btn.setOnClickListener(oclBTN);
            //动态添加文本
            ll.addView(btn);
        }
    }

    View.OnClickListener oclBTN = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            subid = String.valueOf(view.getId());
            Log.d(TAG, "onClick: ..." + subid);
            newsList = new ArrayList<>();
            adapter = new NewsAdapter(newsList, context);
            new NewsRequestNet().NewsRequestNet(subid, newsList, adapter);
            lvMain.setAdapter(adapter);

        }
    };


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

       /* menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menu.isMenuShowing())
                    menu.toggle();
            }
        });*/


        getFragmentManager().beginTransaction().replace(R.id.frame_left, leftMenuFragment).commit();


        getFragmentManager().beginTransaction().replace(R.id.frame_right, rightMenuFragment).commit();
    }

}

