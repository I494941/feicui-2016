package android.wjf.android06.feicuiedu.com.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.wjf.android06.feicuiedu.com.test.db.AssetsDBManager;
import android.wjf.android06.feicuiedu.com.test.db.DBRead;
import android.wjf.android06.feicuiedu.com.test.R;
import android.wjf.android06.feicuiedu.com.test.adapter.TelclassAdapter;
import android.wjf.android06.feicuiedu.com.test.entity.TelclassInfo;
import android.wjf.android06.feicuiedu.com.test.utils.ToastUtil;

import java.io.IOException;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

/**
 * 通讯大全页面
 */
public class TelmgrActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "TelmgrActivity";

    /**
     * 全局定义ListView控件
     */
    private ListView listView;
    /**
     * 全局定义TelclassAdapter
     */
    private TelclassAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telmsg);
        // 初始控件
        listView = (ListView) findViewById(R.id.listview);
        adapter = new TelclassAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private void initAppDBFile() {
        // 检测是否存在通讯大全DB文件
        if (!DBRead.isExistsTeldbFile()) {
            try {
                // 将本地项目中的Assets/db/commonnum.db文件复制写出到 DBRead.telFile文件中
                AssetsDBManager.copyAssetsFileToFile(getApplicationContext(), "db/commonnum.db", DBRead.telFile);
            } catch (IOException e) {
                ToastUtil.show(this, "初始通讯大全数据库文件异常", Toast.LENGTH_SHORT);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 适配数据
        initAppDBFile();
        adapter.clearDataTOAdapter();
        adapter.addDataToAdapter(new TelclassInfo("本地电话", 0));
        // 本地电话 分类
        try {
            adapter.addDataToAdapter(DBRead.readTeldbClasslist());
        } catch (Exception e) { // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // db库内的电话分类
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemClick: "+"11111");
        // 本地通话
        if (position == 0) {
            Log.d(TAG, "onItemClick: "+"22222");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            startActivity(intent);
            return;
        }
        Log.d(TAG, "onItemClick: "+"33333");
        // 取出当前选择的选项实体内容
        TelclassInfo classInfo = adapter.getItem(position);
        // 跳转至电话浏览页面,且传入idx,并且根据idx跳转
        Intent intent = new Intent(this, TellistActivity.class);
        intent.putExtra("idx", classInfo.idx);
        startActivity(intent);
    }
}

