package android.wjf.android06.feicuiedu.com.newsapp.model.dao;

/**
 * Created by ad06-wjf on 2016/11/28.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.News;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.SubType;

import java.util.ArrayList;


/**
 * 数据库管理类
 *
 * @author Administrator
 */
public class NewsSubTypeDBManager {
    //单例模式
    private static NewsSubTypeDBManager dbManager;
    private DBOpenHelper helper;

    public NewsSubTypeDBManager(Context context) {
        helper = new DBOpenHelper(context);
    }

    //同步锁
    public static NewsSubTypeDBManager getNewsDBManager(Context context) {
        if (dbManager == null) {
            synchronized (NewsSubTypeDBManager.class) {
                if (dbManager == null) {
                    dbManager = new NewsSubTypeDBManager(context);
                }
            }
        }
        return dbManager;
    }

    /**
     * 添加
     */
    public void insertSubType(SubType subType) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Subid", subType.getSubid());
        values.put("Subgroup", subType.getSubgroup());

        db.insert("subType", null, values);
        db.close();
    }

    /**
     * 数据数量
     */
    public long getSubidCount() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(*) from subType", null);
        long len = -1;
        if (cursor.moveToFirst()) {
            do {
                len++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return len;
    }

    /**
     * 查询数据
     */
    public ArrayList<SubType> querySubType() {
        ArrayList<SubType> subTypeList = new ArrayList<SubType>();
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select * from subType order by subid" ;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int subid = cursor.getInt(cursor.getColumnIndex("subid"));
                String subgroup = cursor.getString(cursor.getColumnIndex("subgroup"));

                SubType subType = new SubType(subid, subgroup);
                subTypeList.add(subType);
            } while (cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return subTypeList;
    }
}
