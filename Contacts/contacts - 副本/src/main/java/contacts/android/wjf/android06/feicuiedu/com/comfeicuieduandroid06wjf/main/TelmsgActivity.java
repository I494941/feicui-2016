package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.adapter.TelclassAdapter;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.db.AssetsDBManager;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.db.DBRead;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.entity.TelclassInfo;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.ToastUtil;

/**
 * Created by ad06-wjf on 2016/11/3.
 */

public class TelmsgActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 本地通话
        if (position == 0) {

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            startActivity(intent);
            return;

        }
        // 取出当前选择的选项实体内容
        TelclassInfo classInfo = adapter.getItem(position);
        // 跳转至电话浏览页面,且传入idx,并且根据idx跳转
        Intent intent = new Intent(this, TellistActivity.class);
        intent.putExtra("idx", classInfo.idx);
        startActivity(intent);

    }


    private void initAppDBFile() {
        // 检测是否存在通讯大全DB文件
        if (!DBRead.isExistsTeldbFile()) {
            try {
                // 将本地项目中的Assets/db/commonnum.db文件复制写出到 DBRead.telFile文件中
                AssetsDBManager.copyAssetsFileToFile(getApplicationContext(), "db/commonnum.db", DBRead.telFile);
            } catch (IOException e) {
                ToastUtil.show(this, "初始通讯大全数据库文件异常",

                        Toast.LENGTH_SHORT);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 适配数据
        initAppDBFile();
        adapter.clearDataTOAdapter();
        adapter.addDataToAdapter(new TelclassInfo("本地电话", 0));// 本地电话 分类
        try {
            adapter.addDataToAdapter(DBRead.readTeldbClasslist());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// db库内的电话分类
        adapter.notifyDataSetChanged();
    }

}
