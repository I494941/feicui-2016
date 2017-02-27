package com.example.daily;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Context context = this;
    //注册
    private Button btnRegister;

    //登陆
    private Button btnLogin;

    //获取用户名
    private EditText etUserName;
    //获取密码
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin = (Button) findViewById(R.id.btn_login);
        etUserName = (EditText) findViewById(R.id.et_user_name);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnRegister.setOnClickListener(listenerRegister);
        btnLogin.setOnClickListener(listenerLogin);
    }

    //注册
    private View.OnClickListener listenerRegister = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    };

    //登陆
    private View.OnClickListener listenerLogin = new View.OnClickListener() {



        @Override
        public void onClick(View v) {

            String userName = etUserName.getText().toString();
            String password = etPassword.getText().toString();

            SQLiteDabseHandle handle = new SQLiteDabseHandle(context);
            SQLiteDatabase database = handle.getSQLite();

            StringBuilder sbSql = new StringBuilder();
            StringBuilder sbSql_ = new StringBuilder();

            sbSql.append("  select             ");
            sbSql.append("      *              ");
            sbSql.append("  from               ");
            sbSql.append("      user_          ");
            sbSql.append("  where              ");
            sbSql.append("      login_name =  '");
            sbSql.append(userName);
            sbSql.append("'   and              ");
            sbSql.append("      password =    '");
            sbSql.append(password);
            sbSql.append("'                    ");

            Cursor cursor = database.rawQuery(sbSql.toString(), null);

            List<UserInfo> result = new ArrayList<UserInfo>();
            while (cursor.moveToNext()) {
                String getPassword = cursor.getString(0);
                String loginName = cursor.getString(1);

                UserInfo userInfo = new UserInfo(loginName, getPassword);
                result.add(userInfo);
            }

            sbSql_.append("  select             ");
            sbSql_.append("      *              ");
            sbSql_.append("  from               ");
            sbSql_.append("      user_          ");
            sbSql_.append("  where              ");
            sbSql_.append("      login_name =  '");
            sbSql_.append(userName);
            sbSql_.append("'                    ");


            Log.d(TAG, "onClick: sbSql_ = "  + sbSql_);
            Log.d(TAG, "onClick: sbSql = " + sbSql);


            Cursor cursor_ = database.rawQuery(sbSql_.toString(), null);

            List<UserInfo> result_ = new ArrayList<UserInfo>();
            while (cursor_.moveToNext()) {
                String getPassword = cursor_.getString(0);
                String loginName = cursor_.getString(1);

                UserInfo userInfo1 = new UserInfo(loginName, getPassword);
                result_.add(userInfo1);
            }

            if (!result.isEmpty()) {

                Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            } else if (!result_.isEmpty()) {

                Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_LONG).show();
            } else {

                Toast.makeText(getApplicationContext(), "用户名不存在", Toast.LENGTH_LONG).show();
            }


        }
    };


}
