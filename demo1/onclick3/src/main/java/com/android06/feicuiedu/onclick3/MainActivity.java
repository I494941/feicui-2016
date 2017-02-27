package com.android06.feicuiedu.onclick3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mybutton_btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybutton_btn = (Button) findViewById(R.id.mybutton_btn);
        mybutton_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mybutton_btn) {
            Toast.makeText(this, "点击事件方法3", Toast.LENGTH_LONG).show();
        }
    }
}
