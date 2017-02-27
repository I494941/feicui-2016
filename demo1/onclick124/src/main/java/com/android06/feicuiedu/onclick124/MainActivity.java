package com.android06.feicuiedu.onclick124;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mybutton_btn1 = null;
    private Button mybutton_btn2 = null;
    private Button mybutton_btn4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybutton_btn1 = (Button) findViewById(R.id.mybutton_btn1);
        mybutton_btn2 = (Button) findViewById(R.id.mybutton_btn2);
        mybutton_btn4 = (Button) findViewById(R.id.mybutton_btn4);

        mybutton_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击事件方法1", Toast.LENGTH_SHORT).show();
            }
        });
        mybutton_btn2.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Toast.makeText(getApplicationContext(), "点击事件方法2", Toast.LENGTH_SHORT).show();
        }
    };

    public void onClick4(View v) {
        Toast.makeText(this, "点击事件方法4", Toast.LENGTH_LONG).show();
    }
}
