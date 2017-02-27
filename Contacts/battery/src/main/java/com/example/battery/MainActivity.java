package com.example.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton tb = null;
    private TextView tv = null;
    private BatteryReceiver receiver = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new BatteryReceiver();
        tv = (TextView) findViewById(R.id.tv);
        tb = (ToggleButton) findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton,
                                         boolean isChecked) {
                // 获取电池电量
                if (isChecked) {
                    IntentFilter filter = new IntentFilter(
                            Intent.ACTION_BATTERY_CHANGED);
                    // 注册BroadcastReceiver
                    registerReceiver(receiver, filter);
                } else {
                    // 停止获取电池电量
                    unregisterReceiver(receiver);
                    tv.setText(null);
                }
            }
        });
    }

    private class BatteryReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int current = intent.getExtras().getInt("level");// 获得当前电量
            int total = intent.getExtras().getInt("scale");// 获得总电量
            int percent = current * 100 / total;
            tv.setText("现在的电量是" + percent + "%。");
        }
    }
}
