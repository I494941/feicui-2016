package com.feicuiedu.android.appswiperefreshlayout;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lv1;
    private SwipeRefreshLayout srfl1;

    private SwipeRefreshLayout.OnRefreshListener orl = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = (ListView) findViewById(R.id.lv_1);
        srfl1 = (SwipeRefreshLayout) findViewById(R.id.srfl_1);

        srfl1.setOnRefreshListener(orl);
        srfl1.setColorSchemeResources();
    }
}
