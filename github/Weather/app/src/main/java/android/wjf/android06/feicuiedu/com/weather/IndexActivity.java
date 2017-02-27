package android.wjf.android06.feicuiedu.com.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ad06-wjf on 2016/12/23.
 */

public class IndexActivity extends AppCompatActivity {

    private TextView tv11;
    private TextView tv12;
    private TextView tv13;
    private TextView tv14;

    private List<Index> indexList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        Intent intent = getIntent();
        // String result=intent.getStringExtra("result");
        String title;
        String zs;
        String tipt;
        String des;
        for (int i = 0; i < 4; i++) {
            title = intent.getStringExtra("title" + i);
            zs = intent.getStringExtra("zs" + i);
            tipt = intent.getStringExtra("tipt" + i);
            des = intent.getStringExtra("des" + i);
            Index index = new Index(des, tipt, title, zs);
            indexList.add(index);
        }


        tv11 = (TextView) findViewById(R.id.tv_11);
        tv12 = (TextView) findViewById(R.id.tv_12);
        tv13 = (TextView) findViewById(R.id.tv_13);
        tv14 = (TextView) findViewById(R.id.tv_14);
        tv11.setText(indexList.get(0).getTitle());
        tv12.setText(indexList.get(0).getZs());
        tv13.setText(indexList.get(0).getTipt());
        tv14.setText(indexList.get(0).getDes());


    }
}
