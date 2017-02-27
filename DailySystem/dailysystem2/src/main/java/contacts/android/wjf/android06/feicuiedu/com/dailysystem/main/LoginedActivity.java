package contacts.android.wjf.android06.feicuiedu.com.dailysystem.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import contacts.android.wjf.android06.feicuiedu.com.dailysystem.R;

/**
 * Created by ad06-wjf on 2016/11/24.
 */

public class LoginedActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;

    private LinearLayout ll1;

    private ReadFragment rf;
    private WriteFragment wf;
    private AboutFragment af;


    private FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logined_activity);
        fm = this.getFragmentManager();

        bindViews();

        txt_channel.performClick();
    }



    //UI组件初始化与事件绑定
    private void bindViews() {
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_better = (TextView) findViewById(R.id.txt_better);
        txt_setting = (TextView) findViewById(R.id.txt_setting);

        // ll1 = (LinearLayout) findViewById(R.id.ll_1);

        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_better.setOnClickListener(this);
        txt_setting.setOnClickListener(this);
    }


    //重置所有文本的选中状态
    private void setSelected() {
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_better.setSelected(false);
        txt_setting.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (rf != null) {
            fragmentTransaction.hide(rf);
        }
        if (wf != null) {
            fragmentTransaction.hide(wf);
        }
        if (af != null) {
            fragmentTransaction.hide(af);
        }
        /* if (fg4 != null) {
            fragmentTransaction.hide(fg4);
        }*/
    }


    @Override
    public void onClick(View v) {
        // FragmentTransaction只能使用一次
        FragmentTransaction ft = fm.beginTransaction();
        hideAllFragment(ft);

        switch (v.getId()) {
            case R.id.txt_channel:
                setSelected();

                txt_channel.setSelected(true);

                /*if (rf == null) {
                    rf = new ReadFragment();
                    ft.add(R.id.ll_1, rf);
                } else {
                    ft.show(rf);
                }*/

               rf = new ReadFragment();
                ft.add(R.id.ll_1, rf);


                break;
            case R.id.txt_message:
                setSelected();

                txt_message.setSelected(true);

               /* if(wf == null){
                    wf = new WriteFragment();
                    ft.add(R.id.ll_1, wf);
                }else{
                    ft.show(wf);
                }*/

                wf = new WriteFragment();
                ft.add(R.id.ll_1, wf);


                break;
            case R.id.txt_better:
                setSelected();

                txt_better.setSelected(true);
                if (af == null) {
                    af = new AboutFragment();
                    ft.add(R.id.ll_1, af);
                } else {
                    ft.show(af);
                }


                break;
            /*case R.id.txt_setting:
                setSelected();

                param.putString("content", "setting fragment");
                param.putInt("index", 3);
                txt_setting.setSelected(true);
                if (fg4 == null) {
                    fg4 = new MyFragment();
                    ft.add(R.id.ly_content, fg4);
                    fg4.setArguments(param);
                } else {
                    ft.show(fg4);
                }


                fg4.rtnData(new MyFragment.IResult() {
                    @Override
                    public void getResult(Map<String, Object> map) {
                        rtnMsg = (Integer) map.get("rtnIndex") + (String) map.get("rtnContent");
                        txt_topbar.setText(rtnMsg);
                    }
                });
                break;*/
        }
        ft.commit();


    }


}
