package android.wjf.android06.feicuiedu.com.newsapp.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.SubType;

import java.util.ArrayList;

/**
 * Created by ad06-wjf on 2016/11/28.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    public DBOpenHelper(Context context) {
        super(context, "newsdb.db", null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table news (_id integer primary key autoincrement,nid integer,stamp text, title text,summary text,icon text,link text,type integer,subid integer)");

        db.execSQL("create table subType (_id integer primary key autoincrement,subid integer,subgroup text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}
