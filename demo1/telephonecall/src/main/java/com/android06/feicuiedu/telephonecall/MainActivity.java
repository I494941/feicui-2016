package com.android06.feicuiedu.telephonecall;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btn;

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 取得资源
        btn = (Button) findViewById(R.id.bt1);
        et = (EditText) findViewById(R.id.et1);

        // 增加事件响应
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               /*// 取得输入的电话号码串
                String inputStr = et.getText().toString();
                Log.d(">>>>", "onClick: "+inputStr);
                // 如果输入不为空创建打电话的Intent
                if (inputStr.trim().length() != 0) {
                    Intent phoneIntent = new Intent();
                    phoneIntent.setAction(Intent.ACTION_CALL);
                    phoneIntent.setData(Uri.parse("tel:" + inputStr));
                    // 启动
                    startActivity(phoneIntent);
                }
                // 否则Toast提示一下
                else {
                    Toast.makeText(MainActivity.this, "不能输入为空", Toast.LENGTH_LONG).show();
                }

*/
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18678294785"));
                startActivity(intent);
            }

        });

    }

}
