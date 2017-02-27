package contacts.android.wjf.android06.feicuiedu.com.dailysystem.main1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import contacts.android.wjf.android06.feicuiedu.com.dailysystem.R;

/**
 * Created by ad06-wjf on 2016/11/7.
 */

public class LoginActivity extends AppCompatActivity {

    private Context context = this;

    //查看日报
    private Button btnRead;

    //新增日报
    private Button btnWrite;

    //退出登录
    private Button btnBack;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        btnRead = (Button) findViewById(R.id.btn_read);
        btnWrite = (Button) findViewById(R.id.btn_write);
        btnBack = (Button) findViewById(R.id.btn_back);

        btnRead.setOnClickListener(ocl);
        btnWrite.setOnClickListener(ocl);
        btnBack.setOnClickListener(ocl);


    }

    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //查看日报
                case R.id.btn_read:
                    Toast.makeText(context, "查看日报", Toast.LENGTH_SHORT).show();

                    intent = new Intent();
                    intent.setClass(context, ReadActivity.class);
                    startActivity(intent);


                    break;
                //新增日报
                case R.id.btn_write:
                    Toast.makeText(context, "新增日报", Toast.LENGTH_SHORT).show();

                    intent = new Intent();
                    intent.setClass(context, WriteActivity.class);
                    startActivity(intent);
                    finish();


                    break;
                //退出登录
                case R.id.btn_back:
                    Toast.makeText(context, "退出登录", Toast.LENGTH_SHORT).show();

                    intent = new Intent();
                    intent.setClass(context, MainActivity.class);
                    startActivity(intent);
                    finish();

                    break;
            }

        }
    };
}
