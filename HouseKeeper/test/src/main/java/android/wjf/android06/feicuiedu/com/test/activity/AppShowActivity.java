package android.wjf.android06.feicuiedu.com.test.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.test.adapter.AppAdapter;
import android.wjf.android06.feicuiedu.com.test.entity.AppInfo;
import android.wjf.android06.feicuiedu.com.test.biz.AppInfoManager;
import android.wjf.android06.feicuiedu.com.test.R;

import java.util.List;

/**
 * Created by ad06-wjf on 2016/11/21.
 */

public class AppShowActivity extends AppCompatActivity {

    private static final String TAG = "AppShowActivity";
    private ImageView ivLeft;
    private TextView tvTitle;
    private ImageView ivRight;

    private Intent intent;
    private Context context;

    private List<AppInfo> appInfos;
    private int id;

    private ProgressBar progressBarArc;
    private ListView appListView;
    private AppAdapter appAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonemgrshowapp);

        context = this;
        intent = getIntent();

        ivLeft = (ImageView) findViewById(R.id.iv_left);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivRight = (ImageView) findViewById(R.id.iv_right);

        progressBarArc = (ProgressBar) findViewById(R.id.progressBar);
        appListView = (ListView) findViewById(R.id.listviewLoad);

        asynLoadApp();


    }



    private void asynLoadApp() {

        progressBarArc.setVisibility(View.VISIBLE);
        appListView.setVisibility(View.INVISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                switch (id) {
                    case R.id.rl_soft_all:
                        appInfos = AppInfoManager.getAppInfoManager(getApplicationContext()).getAllPackageInfo(true);
                        break;
                    case R.id.rl_soft_sys:
                        appInfos = AppInfoManager.getAppInfoManager(getApplicationContext()).getSystemPackageInfo(true);
                        break;
                    case R.id.rl_soft_use:
                        appInfos = AppInfoManager.getAppInfoManager(getApplicationContext()).getUserPackageInfo(true);
                        break;
                }
                /*更新UI*/

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBarArc.setVisibility(View.INVISIBLE);
                        appListView.setVisibility(View.VISIBLE);
                        // appAdapter.setDataToAdapter(appInfos);
                       //  appAdapter.notifyDataSetChanged();
                    }
                });


            }
        }).start();
    }

    /**
     * 应用删除广播接收器
     */
    public class AppDelRecevice extends BroadcastReceiver {
        public static final String ACTION_APPDEL = "com.androidy.app.phone.del";

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_PACKAGE_REMOVED) || action.equals(ACTION_APPDEL)) {
                asynLoadApp();
            }
        }
    }

}
