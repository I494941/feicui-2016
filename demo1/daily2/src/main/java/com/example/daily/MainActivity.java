package com.example.daily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //注册
    private Button btnRegister;

    //登陆
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnRegister.setOnClickListener(listenerRegister);
        btnLogin.setOnClickListener(listenerLogin);
    }

    //注册
    private View.OnClickListener listenerRegister = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
    };

    //登陆
    private View.OnClickListener listenerLogin = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    };


}
