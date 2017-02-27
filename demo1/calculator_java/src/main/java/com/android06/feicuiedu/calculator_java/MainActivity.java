package com.android06.feicuiedu.calculator_java;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建一个布局管理器
        RelativeLayout relativeLayout = new RelativeLayout(context);

        ViewGroup.LayoutParams viewLayoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(viewLayoutParams);
        //relativeLayout.setBackgroundColor(Color.BLUE);
        setContentView(relativeLayout);

        // 创建一个TextView
        EditText editText = new EditText(context);
        RelativeLayout.LayoutParams editTextParams = new RelativeLayout.LayoutParams(
                dip2px(1000), dip2px(300));
        editText.setLayoutParams(editTextParams);
        editText.setGravity(Gravity.RIGHT);
        editText.setId(R.id.et1);

        // 向Layout容器中添加EditView
        relativeLayout.addView(editText);

        // 创建按钮"7"
        Button button7 = new Button(context);
        button7.setText("7");
        button7.setId(R.id.bt7);
        RelativeLayout.LayoutParams button7Params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button7Params.addRule(RelativeLayout.BELOW, editText.getId());
        button7.setLayoutParams(button7Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button7);

        // 创建按钮"8"
        Button button8 = new Button(context);
        button8.setText("8");
        button8.setId(R.id.bt8);
        RelativeLayout.LayoutParams button8Params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button8Params.addRule(RelativeLayout.RIGHT_OF, button7.getId());
        button8Params.addRule(RelativeLayout.ALIGN_TOP, button7.getId());
        button8.setLayoutParams(button8Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button8);

        // 创建按钮"9"
        Button button9 = new Button(context);
        button9.setText("9");
        button9.setId(R.id.bt9);
        RelativeLayout.LayoutParams button9Params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button9Params.addRule(RelativeLayout.RIGHT_OF, button8.getId());
        button9Params.addRule(RelativeLayout.ALIGN_BOTTOM, button8.getId());
        button9.setLayoutParams(button9Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button9);

        // 创建按钮"/"
        Button buttonDiv = new Button(context);
        buttonDiv.setText("/");
        buttonDiv.setId(R.id.btDiv);
        RelativeLayout.LayoutParams buttonDivParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonDivParams.addRule(RelativeLayout.RIGHT_OF, button9.getId());
        buttonDivParams.addRule(RelativeLayout.ALIGN_BOTTOM, button9.getId());
        buttonDiv.setLayoutParams(buttonDivParams);
        // 向Layout容器中添加按钮
        relativeLayout.addView(buttonDiv);

        // 创建按钮"4"
        Button button4 = new Button(context);
        button4.setText("4");
        button4.setId(R.id.bt4);
        RelativeLayout.LayoutParams button4Params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button4Params.addRule(RelativeLayout.BELOW, button7.getId());
        button4.setLayoutParams(button4Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button4);

        // 创建按钮"5"
        Button button5 = new Button(context);
        button5.setText("5");
        button5.setId(R.id.bt5);
        RelativeLayout.LayoutParams button5Params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button5Params.addRule(RelativeLayout.RIGHT_OF, button4.getId());
        button5Params.addRule(RelativeLayout.ALIGN_TOP, button4.getId());
        button5.setLayoutParams(button5Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button5);

        // 创建按钮"6"
        Button button6 = new Button(context);
        button6.setText("6");
        button6.setId(R.id.bt6);
        RelativeLayout.LayoutParams button6Params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button6Params.addRule(RelativeLayout.RIGHT_OF, button5.getId());
        button6Params.addRule(RelativeLayout.ALIGN_BOTTOM, button5.getId());
        button6.setLayoutParams(button6Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button6);

        // 创建按钮"*"
        Button buttonMul = new Button(context);
        buttonMul.setText("*");
        buttonMul.setId(R.id.btMul);
        RelativeLayout.LayoutParams buttonMulParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonMulParams.addRule(RelativeLayout.RIGHT_OF, button6.getId());
        buttonMulParams.addRule(RelativeLayout.ALIGN_BOTTOM, button6.getId());
        buttonMul.setLayoutParams(buttonMulParams);
        // 向Layout容器中添加按钮
        relativeLayout.addView(buttonMul);

        // 创建按钮"1"
        Button button1 = new Button(context);
        button1.setText("1");
        button1.setId(R.id.bt1);
        RelativeLayout.LayoutParams button1Params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button1Params.addRule(RelativeLayout.BELOW, button4.getId());
        button1.setLayoutParams(button1Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button1);

        // 创建按钮"2"
        Button button2 = new Button(context);
        button2.setText("2");
        button2.setId(R.id.bt2);
        RelativeLayout.LayoutParams button2Params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button2Params.addRule(RelativeLayout.RIGHT_OF, button1.getId());
        button2Params.addRule(RelativeLayout.ALIGN_TOP, button1.getId());
        button2.setLayoutParams(button2Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button2);

        // 创建按钮"3"
        Button button3 = new Button(context);
        button3.setText("3");
        button3.setId(R.id.bt3);
        RelativeLayout.LayoutParams button3Params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button3Params.addRule(RelativeLayout.RIGHT_OF, button2.getId());
        button3Params.addRule(RelativeLayout.ALIGN_BOTTOM, button2.getId());
        button3.setLayoutParams(button3Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button3);

        // 创建按钮"-"
        Button buttonMin = new Button(context);
        buttonMin.setText("-");
        buttonMin.setId(R.id.btMin);
        RelativeLayout.LayoutParams buttonMinParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonMinParams.addRule(RelativeLayout.RIGHT_OF, button3.getId());
        buttonMinParams.addRule(RelativeLayout.ALIGN_BOTTOM, button3.getId());
        buttonMin.setLayoutParams(buttonMinParams);
        // 向Layout容器中添加按钮
        relativeLayout.addView(buttonMin);

        // 创建按钮"0"
        Button button0 = new Button(context);
        button0.setText("0");
        button0.setId(R.id.bt0);
        RelativeLayout.LayoutParams button0Params = new RelativeLayout.LayoutParams(
                530,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button0Params.addRule(RelativeLayout.BELOW, button1.getId());
        button0.setLayoutParams(button0Params);
        // 向Layout容器中添加按钮
        relativeLayout.addView(button0);

        // 创建按钮"="
        Button buttonEqu = new Button(context);
        buttonEqu.setText("=");
        buttonEqu.setId(R.id.btEqu);
        RelativeLayout.LayoutParams buttonEquParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonEquParams.addRule(RelativeLayout.ALIGN_LEFT, button3.getId());
        buttonEquParams.addRule(RelativeLayout.ALIGN_TOP, button0.getId());
        buttonEqu.setLayoutParams(buttonEquParams);
        // 向Layout容器中添加按钮
        relativeLayout.addView(buttonEqu);

        // 创建按钮"+"
        Button buttonPlus = new Button(context);
        buttonPlus.setText("+");
        buttonPlus.setId(R.id.btPlus);
        RelativeLayout.LayoutParams buttonPlusParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonPlusParams.addRule(RelativeLayout.RIGHT_OF, buttonEqu.getId());
        buttonPlusParams.addRule(RelativeLayout.ALIGN_BOTTOM, buttonEqu.getId());
        buttonPlus.setLayoutParams(buttonPlusParams);
        // 向Layout容器中添加按钮
        relativeLayout.addView(buttonPlus);

    }

    public int dip2px(float dpValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}

