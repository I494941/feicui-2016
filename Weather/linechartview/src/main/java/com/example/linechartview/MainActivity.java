package com.example.linechartview;

import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XYView05 xyview05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        xyview05 = (XYView05) findViewById(R.id.My_XYView05);

        List<PointF> pointFs = new ArrayList<PointF>();
        pointFs.add(new PointF(0.3F, 0.5F));
        pointFs.add(new PointF(1F, 22.7F));
        pointFs.add(new PointF(2F, 33.5F));
        pointFs.add(new PointF(3F, 36.2F));


        xyview05.setData(pointFs, "X轴提示文字", "Y轴提示文字",MainActivity.this);
    }

}

