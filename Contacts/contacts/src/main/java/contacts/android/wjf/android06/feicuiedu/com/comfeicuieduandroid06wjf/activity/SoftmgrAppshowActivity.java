package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.base.BaseActivity;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.biz.AppInfoManager;

import static android.R.attr.id;

/**
 * Created by ad06-wjf on 2016/11/9.
 */

public class SoftmgrAppshowActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_phonemgrshowapp);
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