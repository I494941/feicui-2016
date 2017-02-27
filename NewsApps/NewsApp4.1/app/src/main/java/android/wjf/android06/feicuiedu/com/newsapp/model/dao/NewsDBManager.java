package android.wjf.android06.feicuiedu.com.newsapp.model.dao;

/**
 * Created by ad06-wjf on 2016/11/28.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.News;

import java.util.ArrayList;


/**
 * 数据库管理类
 *
 * @author Administrator
 */
public class NewsDBManager {
    //单例模式
    private static NewsDBManager dbManager;
    private DBOpenHelper helper;

    public NewsDBManager(Context context) {
        helper = new DBOpenHelper(context);
    }

    //同步锁
    public static NewsDBManager getNewsDBManager(Context context) {
        if (dbManager == null) {
            synchronized (NewsDBManager.class) {
                if (dbManager == null) {
                    dbManager = new NewsDBManager(context);
                }
            }
        }
        return dbManager;
    }

    /**
     * 添加
     */
    public void insertNews(News news) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nid", news.getNid());
        values.put("stamp", news.getStamp());
        values.put("title", news.getTitle());
        values.put("summary", news.getSummary());
        values.put("icon", news.getIcon());
        values.put("link", news.getLink());
        values.put("type", news.getType());
        values.put("subid", news.getSubid());
        db.insert("news", null, values);
        db.close();
    }

    /**
     * 数据数量
     */
    public long getCount(int subid) {
        SQLiteDatabase db = helper.getReadableDatabase();

        String sql = "select * from news where subid = "+subid;
        Log.d("1111", "getCount: "+sql);
        Cursor cursor = db.rawQuery(sql, null);
        long len = 0;
        if (cursor.moveToFirst()) {
            do {
                len++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        Log.d("1111", "getCount: len"+len);

        return len;
    }

    /**
     * 查询数据
     */
    public ArrayList<News> queryNews(int count, int offset, int tmpsubid) {
        ArrayList<News> newsList = new ArrayList<News>();
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select * from news where subid="+ tmpsubid +" order by _id  limit " + count + " offset " + offset;
        Log.d("2323", "queryNews: sql"+sql);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int nid = cursor.getInt(cursor.getColumnIndex("nid"));
                String stamp = cursor.getString(cursor.getColumnIndex("stamp"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String summary = cursor.getString(cursor.getColumnIndex("summary"));
                String icon = cursor.getString(cursor.getColumnIndex("icon"));
                String link = cursor.getString(cursor.getColumnIndex("link"));
                int type = cursor.getInt(cursor.getColumnIndex("type"));
                int subid = cursor.getInt(cursor.getColumnIndex("subid"));
                News news = new News(nid, stamp, title, summary, icon, link, type, subid);
                newsList.add(news);
            } while (cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return newsList;
    }
}
