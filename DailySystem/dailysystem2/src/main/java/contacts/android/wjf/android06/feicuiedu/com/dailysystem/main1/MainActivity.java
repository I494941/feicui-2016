package contacts.android.wjf.android06.feicuiedu.com.dailysystem.main1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import contacts.android.wjf.android06.feicuiedu.com.dailysystem.R;
import contacts.android.wjf.android06.feicuiedu.com.dailysystem.db.UserHelper;

/**
 * Created by ad06-wjf on 2016/11/4.
 */

public class MainActivity extends AppCompatActivity {

    private Context context = this;
    //注册
    private Button btnRegister;
    //登陆
    private Button btnLogin;
    //获取用户名
    private EditText edInputName;
    //获取密码
    private EditText edInputPassword;
    //获取用户名 字符串
    private String strInputName;
    //获取密码 字符串
    private String strInputPassword;

    private UserHelper userHelper;

    private SQLiteDatabase dabase;

    Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnLogin = (Button) findViewById(R.id.btn_login);
        edInputName = (EditText) findViewById(R.id.et_user_name);
        edInputPassword = (EditText) findViewById(R.id.et_password);

        btnRegister.setOnClickListener(ocl);
        btnLogin.setOnClickListener(ocl);
    }

    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_register:

                    Toast.makeText(context, "注册", Toast.LENGTH_SHORT).show();

                    intent = new Intent();
                    intent.setClass(MainActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    finish();

                    break;
                case R.id.btn_login:
                    Toast.makeText(context, "登录", Toast.LENGTH_SHORT).show();

                    strInputName = edInputName.getText().toString();
                    strInputPassword = edInputPassword.getText().toString();

                    String strSql = "select * from user_ where u_name = ? and u_password = ?";

                    userHelper = new UserHelper(context);
                    dabase = userHelper.getWritableDatabase();
                    Cursor cursor = dabase.rawQuery(strSql, new String[]{strInputName, strInputPassword});

                    Map<String, String> map = new HashMap<String, String>();

                    while (cursor.moveToNext()) {
                        String strId = cursor.getString(0);
                        String strName = cursor.getString(1);
                        String strPassword = cursor.getString(2);

                        map.put("u_id", strId);
                        map.put("d_name", strName);
                        map.put("u_password", strPassword);
                    }
                    if (map.isEmpty()) {
                        Toast.makeText(context, "验证不通过！", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(context, "登录成功！", Toast.LENGTH_LONG).show();

                        intent = new Intent();
                        intent.setClass(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    break;
            }
        }
    };

}
