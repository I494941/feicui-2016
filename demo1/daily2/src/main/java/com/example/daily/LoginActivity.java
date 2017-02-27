package com.example.daily;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by apple on 16/10/21.
 */

public class LoginActivity extends AppCompatActivity {

    //查看日报
    private Button btnRead;

    //新增日报
    private Button btnWrite;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        btnRead = (Button) findViewById(R.id.btn_read);
        btnWrite = (Button) findViewById(R.id.btn_write);

        btnRead.setOnClickListener(listenerRead);
        btnWrite.setOnClickListener(listenerWrite);
    }

    //查看日报
    private View.OnClickListener listenerRead = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,LoginedActivity.class);
            startActivity(intent);
        }
    };
    //新增日报
    private View.OnClickListener listenerWrite = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,LoginedActivity.class);
            startActivity(intent);
        }
    };
}
