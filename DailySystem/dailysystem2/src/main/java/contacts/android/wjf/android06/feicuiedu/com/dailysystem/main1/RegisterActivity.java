package contacts.android.wjf.android06.feicuiedu.com.dailysystem.main1;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import contacts.android.wjf.android06.feicuiedu.com.dailysystem.R;
import contacts.android.wjf.android06.feicuiedu.com.dailysystem.db.UserHelper;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUserName;

    private RadioButton rbFemale;

    private RadioButton rbMale;

    private EditText etBirthday;

    private EditText etPassword;

    private EditText etConfirmPassword;

    private Button btnSave;

    private Button btnReturn;

    private Context context;

    private UserHelper userHelper;

    private SQLiteDatabase dabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        context = this;

        etUserName = (EditText) findViewById(R.id.et_user_name);

        rbFemale = (RadioButton) findViewById(R.id.rb_female);
        rbMale = (RadioButton) findViewById(R.id.rb_male);

        etBirthday = (EditText) findViewById(R.id.et_birthday);
        etPassword = (EditText) findViewById(R.id.et_password);
        etConfirmPassword = (EditText) findViewById(R.id.et_confirm_password);

        btnSave = (Button) findViewById(R.id.btn_save);
        btnReturn = (Button) findViewById(R.id.btn_return);

        btnSave.setOnClickListener(ocl);
        btnReturn.setOnClickListener(ocl);
    }

    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_save:
                    String userName = String.valueOf(etUserName.getText());
                    String password = String.valueOf(etPassword.getText());
                    String confirmPassword = String.valueOf(etConfirmPassword.getText());

                    if (!password.equals(confirmPassword)) {

                        Toast.makeText(context, "两次输入密码不同，请重新输入！！", Toast.LENGTH_SHORT).show();

                    } else {
                        String userId = String.valueOf(System.currentTimeMillis());
                        String strSql = "insert into user_(u_id, u_name,u_password) values(?,?,?)";
                        userHelper = new UserHelper(context);
                        dabase = userHelper.getWritableDatabase();
                        dabase.execSQL(strSql, new String[]{userId, userName, password});
                        Toast.makeText(context, "保存成功!", Toast.LENGTH_SHORT).show();

                    }

                    break;
                case R.id.btn_return:
                    Toast.makeText(context, "返回", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(context, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };


}
