package contacts.android.wjf.android06.feicuiedu.com.handlerdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    private View.OnClickListener ocl = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {

            switch (v.getId()) {
                case R.id.btn1:

                    btn1.setBackgroundColor(Color.GREEN);
                    btn1.setText("罗布特.唐尼");
                    break;
                case R.id.btn2:

                    MyHandler myHandler = new MyHandler((Button) v);
                    Message message = new Message();
                    message.what = 1;
                    message.obj = "嬴政";
                    myHandler.sendMessageDelayed(message,2000);


                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(ocl);
        btn2.setOnClickListener(ocl);

        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, 800);
        animation.setDuration(3000);
        animation.setRepeatCount(1000);
        btn1.startAnimation(animation);
    }



}
