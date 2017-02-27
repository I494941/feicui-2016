package android.wjf.android06.feicuiedu.com.housekeeper.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.wjf.android06.feicuiedu.com.housekeeper.utils.LogUtil;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG, getClass().getSimpleName() + " onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG, getClass().getSimpleName() + " onResume()");
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        LogUtil.d(TAG, getClass().getSimpleName() + " onPause()");
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        LogUtil.d(TAG, getClass().getSimpleName() + " onStop()");
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        //清空Activity
        if (onlineActivityList.contains(this)) {
            onlineActivityList.remove(this);
        }
    }

    /**
     * 用来保存所在存在的Activity
     */
    private static ArrayList<BaseActivity> onlineActivityList = new ArrayList<BaseActivity>();

    /**
     * 依次退出当前存在的所有Activity
     */

    public static void finishAll() {
        Iterator<BaseActivity> iterator = onlineActivityList.iterator();
        while (iterator.hasNext()) {
            iterator.next().finish();
        }
    }


    //普通跳转

    protected void startActivity(Class<?> targetClass) {
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
    } //传递参数的跳转

    protected void startActivity(Class<?> targetClass, Bundle bundle) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
    } //带动画的跳转

    protected void startActivity(Class<?> targetClass, int inAnimID, int outAnimID) {
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
        overridePendingTransition(inAnimID, outAnimID);
    } //带动画跳转，并传递参数

    protected void startActivity(Class<?> targetClass, int inAnimID, int outAnimID, Bundle bundle) {
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(inAnimID, outAnimID);
    }
}

