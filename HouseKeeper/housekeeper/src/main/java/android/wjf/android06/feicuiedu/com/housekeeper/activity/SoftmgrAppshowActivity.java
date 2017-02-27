package android.wjf.android06.feicuiedu.com.housekeeper.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.wjf.android06.feicuiedu.com.housekeeper.R;
import android.wjf.android06.feicuiedu.com.housekeeper.adapter.AppAdapter;
import android.wjf.android06.feicuiedu.com.housekeeper.base.BaseActivity;
import android.wjf.android06.feicuiedu.com.housekeeper.biz.AppInfoManager;
import android.wjf.android06.feicuiedu.com.housekeeper.entity.AppInfo;
import android.wjf.android06.feicuiedu.com.housekeeper.view.ActionBarView;

import java.util.List;


/**
 * Created by ad06-wjf on 2016/11/14.
 */

/**
 * 显示（所有，系统，用户）软件列表界面 -------------------- * del app 的系统广播 action
 */
public class SoftmgrAppshowActivity extends BaseActivity {

    private Context context = this;

    private ActionBarView progressBarArc;
    private ListView appListView;
    private List<AppInfo> appInfos;
    private AppAdapter appAdapter = new AppAdapter(context);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonemgrshowapp);

        progressBarArc = (ActionBarView) findViewById(R.id.actionBar);
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
                        appAdapter.setDataToAdapter(appInfos);
                        appAdapter.notifyDataSetChanged();
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
