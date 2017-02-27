package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.input);
        textView = (TextView)findViewById(R.id.output);

        //设置EditText按键输入时的事件
        editText.setOnKeyListener(new EditText.OnKeyListener(){
            @Override
            public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
            // TODO Auto-generated method stub
                textView.setText(editText.getText());//获取edittext的内容
                return false;
            }
        });
    }
}
