package com.android06.feicuiedu.onclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//3.public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button mybutton_btn = null;

    /**
     * 点击事件的方法
     * 1:匿名内部类
     * 2:内部类
     * 3:实现OnClickListener接口
     * 4:按钮onClick属性
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybutton_btn = (Button) findViewById(R.id.mybutton_btn);

        /**
         * 1:匿名内部类
         * */
      /*  mybutton_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击事件方法1",Toast.LENGTH_LONG).show();
            }
        });
    }*/

        /**
         * 2:内部类
         * */

     /*   mybutton_btn.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            Toast.makeText(getApplicationContext(),"点击事件方法2",Toast.LENGTH_LONG).show();
        }
    };*/

        /**
         * 3:实现OnClickListener接口
         * */
    /*    mybutton_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mybutton_btn){
            Toast.makeText(this,"点击事件方法3",Toast.LENGTH_LONG).show();
        }
    }*/

    }
    /**
     * 4:按钮onClick属性
     * */
        public void onClick2(View v){
            Toast.makeText(this,"点击事件方法4",Toast.LENGTH_LONG).show();
    }

}
