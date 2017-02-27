package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.adapter.RuningAppAdapter;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.base.BaseActivity;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.biz.AppInfoManager;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.entity.RuningAppInfo;

/**
 * Created by ad06-wjf on 2016/11/9.
 */

public class SpeedupActivity extends BaseActivity {

    private ListView runingApplistView;
    private RuningAppAdapter runingAppAdapter;
    private Button btn_clear; // 一键清理
    private CheckBox cb_checkClearAll; // 全选
    private Button btn_showall; // 显示app(系统?用户)
    private ProgressBar progressBarArc; // 加载中ui
    private TextView tv_ramMessage; // 运行内存文本
    private ProgressBar pb_ram; // 运行内存
    private TextView tv_phoneName;
    private TextView tv_phoneModle;
    private Map<Integer, List<RuningAppInfo>> runingAppinfos = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speedup);


        // 运行中应用程序列表控件
        runingAppAdapter = new RuningAppAdapter(this);
        runingApplistView = (ListView) findViewById(R.id.listviewLoad);
        runingApplistView.setAdapter(runingAppAdapter);


    String title = getResources().getString(R.string.setting);

    initActionBar(title, R.drawable.btn_homeasup_default, -1,clickListener);

    private void initMainButton() {
        tv_phoneName = (TextView) findViewById(R.id.tv_phoneName);
        tv_phoneModle = (TextView) findViewById(R.id.tv_phoneModel);
        pb_ram = (ProgressBar) findViewById(R.id.pb_ram);
        tv_ramMessage = (TextView) findViewById(R.id.tv_ramMessage);
        progressBarArc = (ProgressBar) findViewById(R.id.progressBar);
        cb_checkClearAll = (CheckBox) findViewById(R.id.cb_all);
        btn_clear = (Button) findViewById(R.id.btn_onekeyClear);
        btn_showall = (Button) findViewById(R.id.btn_showapp);
        btn_clear.setOnClickListener(clickListener);
        btn_showall.setOnClickListener(clickListener);
        cb_checkClearAll.setOnCheckedChangeListener(changeListener);
        initPhoneData();//设置手机信息
        initRamData();//设置内存
    }

    private CompoundButton.OnCheckedChangeListener changeListener = new
            CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean
                        isChecked) {
                    // 将运行中应用程序列表全选
                    List<RuningAppInfo> appInfos = runingAppAdapter.getDataList();
                    for (RuningAppInfo appInfo : appInfos) {
                        appInfo.setClear(isChecked);
                    }
                    // 更新适配器
                    runingAppAdapter.notifyDataSetChanged();
                }
            };

    private void loadData() {
        progressBarArc.setVisibility(View.VISIBLE);
        runingApplistView.setVisibility(View.INVISIBLE);
        // 新开线程执行加载操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取所有正在运行进程
                runingAppinfos =
                        AppInfoManager.getAppInfoManager(getApplicationContext()).getRuningAppInfos();
                // 到UI 线程执行更新、修改UI 的操作
                // runOnUiThread()?Handler?AsyncTask<Params, Progress,Result >
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initRamData();
                        progressBarArc.setVisibility(View.INVISIBLE);
                        runingApplistView.setVisibility(View.VISIBLE);
                        // 默认只需显示出非系统的进程
                        runingAppAdapter.setDataToAdapter(runingAppinfos.get(AppInfoManager.
                                RUNING_APP_TYPE_USER));
                        runingAppAdapter.setState(RuningAppAdapter.STATE_SHOW_USER);
                        runingAppAdapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }


    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int viewID = v.getId();
            switch (viewID) {
                case R.id.iv_left://actionbar 中的箭头图片，跳转到主界面
                    startActivity(HomeActivity.class);
                    finish();
                    break;
                case R.id.btn_onekeyClear://一键清理按钮
                    // kill 选中的
                    List<RuningAppInfo> appInfos =
                            runingAppAdapter.getDataList();
                    for (RuningAppInfo appInfo : appInfos) {
                        if (appInfo.isClear()) {
                            String packageName = appInfo.getPackageName();
                            AppInfoManager.getAppInfoManager(getApplicationContext()).killProces
                            ses(packageName);
                        }
                    }
                    // 重新加载刷新数据
                    loadData();
                    cb_checkClearAll.setChecked(false);
                    break;
                case R.id.btn_showapp://展示软件按钮
                    if (runingAppinfos != null) {
                        switch (runingAppAdapter.getState()) {
                            // 在显示用户应用状态下
                            case RuningAppAdapter.STATE_SHOW_USER:
                                runingAppAdapter.setDataToAdapter(runingAppinfos.get(AppInfoManager.
                                        RUNING_APP_TYPE_SYS));
                                runingAppAdapter.setState(RuningAppAdapter.STATE_SHOW_ALL);
                                btn_showall.setText(getResources().getString(R.string.speedup_show_u
                                        serapp));
                                break;
                            // 在显示所有应用状态下
                            case RuningAppAdapter.STATE_SHOW_ALL:
                                runingAppAdapter.setDataToAdapter(runingAppinfos.get(AppInfoManager.RUNING_APP_TYPE_USER));
                                runingAppAdapter.setState(RuningAppAdapter.STATE_SHOW_USER);
                                btn_showall.setText(getResources().getString(R.string.speedup_show_s
                                        ysapp));
                                break;
                        }
                        runingAppAdapter.notifyDataSetChanged();
                    }
                    break;
                default:
                    break;
            }
        }
    };
}


