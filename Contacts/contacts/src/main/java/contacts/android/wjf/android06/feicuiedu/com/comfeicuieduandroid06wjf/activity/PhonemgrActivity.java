package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.activity;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.adapter.PhonemgrAdapter;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.base.BaseActivity;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.biz.MemoryManager;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.CommonUtil;

import static contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R.id.pb_battery;
import static contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R.id.tv_battery;

/**
 * Created by ad06-wjf on 2016/11/10.
 */

public class PhonemgrActivity extends BaseActivity {

    private LinearLayout layout_battery;
    private TextView tv_battery;
    private ProgressBar pb_battery;
    private ProgressBar pb_loading;
    private ListView exListView;

    BatteryBroadcastReceiver broadcastReceiver;
    int currentBattery;
    int temperatureBattery;
    String title;
    String text;
    PhonemgrAdapter phonemgrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonemgr);

        // 初始化ActionBar @see super class ActionBarActivity
        String title = getResources().getString(R.string.phonemgr);
        initActionBar(title, R.drawable.btn_homeasup_default, -1,clickListener);
        initMainButton();
        exListView = (ListView) findViewById(R.id.listviewLoad);

        phonemgrAdapter = new PhonemgrAdapter(this);
        exListView.setAdapter(phonemgrAdapter);
        // 初始化手机检测信息
        new Thread(new Runnable() {
            @Override
            public void run() {
                initAdapterData();
            }
        }).start();


    }


    /**
     * 初始化控件
     */
    private void initMainButton() {
        layout_battery = (LinearLayout) findViewById(R.id.ll_layout_battery);
        layout_battery.setOnClickListener(clickListener);
        tv_battery = (TextView) findViewById(R.id.tv_battery);
        pb_battery = (ProgressBar) findViewById(R.id.pb_battery);
        pb_loading = (ProgressBar) findViewById(R.id.progressBar);

        // 注册电池电量广播接收器(放在控件findView 后面)
        broadcastReceiver = new BatteryBroadcastReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastReceiver, filter);

    }

    /**
     * 电池电量的广播接收器
     */
    public class BatteryBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
                Bundle bundle = intent.getExtras();
                int maxBattery = (Integer) bundle.get(BatteryManager.EXTRA_SCALE); // 总电量
                currentBattery = (Integer) bundle.get(BatteryManager.EXTRA_LEVEL); // 当前电量
                temperatureBattery = (Integer) bundle.get(BatteryManager.EXTRA_TEMPERATURE); // 电池温度
                pb_battery.setMax(maxBattery);
                pb_battery.setProgress(currentBattery);
                int current100 = currentBattery * 100 / maxBattery;
                tv_battery.setText(current100 + "%");//TextView 显示电量
            }
        }
    }


    public void initAdapterData() {

        /**
         *获取全部运行内存
         *获取剩余运行内存
         */

        title = "全部运行内存" +  CommonUtil.getFileSize(MemoryManager.getPhoneTotalRamMemory());
        text = "剩余运行内存" + CommonUtil.getFileSize(MemoryManager.getPhoneFreeRamMemory(this));


    /**
     *获取手机分辩率
     *获取相机分辩率
     */

        title = "手机分辩率:" + manager.getResolution();
        text = "相机分辩率:" + manager.getMaxPhotoSize();

        /**
         *获取基带版本
         *获取是否ROOT
         */
        title = "基带版本:" + manager.getPhoneSystemBasebandVersion();
        text = "是否ROOT:" + (manager.isRoot() ? "是" : "否");


    }


}
