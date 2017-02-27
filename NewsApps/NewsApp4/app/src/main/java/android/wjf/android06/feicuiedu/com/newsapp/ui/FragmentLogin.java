package android.wjf.android06.feicuiedu.com.newsapp.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.wjf.android06.feicuiedu.com.newsapp.R;

/**
 * Created by wangjinfei on 16/12/8.
 */

public class FragmentLogin extends Fragment {

    private Context context;

    private LayoutInflater lif;

    private Button buttonRegister;
    private Button buttonForgetPass;
    private Button buttonLogin;

    private EditText editTextNickname;
    private EditText editTextPwd;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();
        lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        buttonRegister = (Button) view.findViewById(R.id.button_register);
        buttonForgetPass = (Button) view.findViewById(R.id.button_forget_pass);
        buttonLogin = (Button) view.findViewById(R.id.button_login);

        editTextNickname = (EditText) view.findViewById(R.id.editText_nickname);
        editTextNickname = (EditText) view.findViewById(R.id.editText_pwd);

        buttonRegister.setOnClickListener(ocl);
        buttonForgetPass.setOnClickListener(ocl);
        buttonLogin.setOnClickListener(ocl);

        return view;
    }

    View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.button_register:
                    Toast.makeText(context, "注册", Toast.LENGTH_SHORT).show();


                    break;
                case R.id.button_forget_pass:
                    Toast.makeText(context, "忘记密码", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.button_login:
                    Toast.makeText(context, "登录", Toast.LENGTH_SHORT).show();

                    break;
            }

        }
    };


}
