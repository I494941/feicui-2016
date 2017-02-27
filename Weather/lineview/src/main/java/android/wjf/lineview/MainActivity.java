package android.wjf.lineview;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LineView01 xyview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        xyview = (LineView01) findViewById(R.id.My_XYView);

        List<PointF> pointFs = new ArrayList<PointF>();
        pointFs.add(new PointF(0F, 10F));
        pointFs.add(new PointF(1F, -10F));
        pointFs.add(new PointF(2F, 0F));
        pointFs.add(new PointF(3F, 0F));
        // pointFs.add(new PointF(4F, 5F));

        xyview.setData(pointFs, "日期", "温度℃",MainActivity.this);
    }
}
