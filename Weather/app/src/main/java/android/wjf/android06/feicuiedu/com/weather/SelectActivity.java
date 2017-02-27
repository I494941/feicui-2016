package android.wjf.android06.feicuiedu.com.weather;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wangjinfei on 16/12/25.
 */

public class SelectActivity extends AppCompatActivity {

    private Button btn;
    private EditText etSelectCity;
    private TextView tvBJ;
    private TextView tvSH;
    private TextView tvSD;
    private TextView tvHN;

    private String selectCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        btn = (Button) findViewById(R.id.btn);
        etSelectCity = (EditText) findViewById(R.id.et_select_city);
        tvBJ = (TextView) findViewById(R.id.tv_bj);
        tvSH = (TextView) findViewById(R.id.tv_sh);
        tvSD = (TextView) findViewById(R.id.tv_sd);
        tvHN = (TextView) findViewById(R.id.tv_hn);

        btn.setOnClickListener(ocl);
        tvBJ.setOnClickListener(ocl);
        tvSH.setOnClickListener(ocl);
        tvSD.setOnClickListener(oclS);
        tvHN.setOnClickListener(oclS);

    }

    View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();

            switch (view.getId()) {
                case R.id.btn:
                    selectCity = String.valueOf(etSelectCity.getText());
                    intent.putExtra("param", selectCity);
                    setResult(100, intent);

                    SelectActivity.this.finish();
                    break;
                case R.id.tv_bj:
                    selectCity = "北京";
                    intent.putExtra("param", selectCity);
                    setResult(100, intent);

                    SelectActivity.this.finish();

                    break;
                case R.id.tv_sh:
                    selectCity = "上海";
                    intent.putExtra("param", selectCity);
                    setResult(100, intent);

                    SelectActivity.this.finish();

                    break;

            }
        }
    };
    View.OnClickListener oclS = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_sd:
                    dialogSD();
                    break;
                case R.id.tv_hn:
                    dialogHN();
                    break;
            }
        }
    };

    private void dialogSD() {
        final String items[] = {"济南", "济宁", "莱芜"};
        //dialog参数设置
        AlertDialog.Builder builder = new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle("山东省"); //设置标题
        //builder.setMessage("是否确认退出?"); //设置内容
        builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
        //设置列表显示，注意设置了列表显示就不要设置builder.setMessage()了，否则列表不起作用。
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(SelectActivity.this, items[which], Toast.LENGTH_SHORT).show();
                etSelectCity.setText(items[which]);
            }
        });
        builder.create().show();
    }

    private void dialogHN() {
        final String items[] = {"郑州", "商丘"};
        //dialog参数设置
        AlertDialog.Builder builder = new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle("河南省"); //设置标题
        //builder.setMessage("是否确认退出?"); //设置内容
        builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
        //设置列表显示，注意设置了列表显示就不要设置builder.setMessage()了，否则列表不起作用。
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(SelectActivity.this, items[which], Toast.LENGTH_SHORT).show();
                etSelectCity.setText(items[which]);
            }
        });
        builder.create().show();
    }
}
