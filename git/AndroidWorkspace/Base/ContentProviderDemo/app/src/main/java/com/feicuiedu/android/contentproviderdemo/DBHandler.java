package com.feicuiedu.android.contentproviderdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chenyan on 2016/12/7.
 */

public class DBHandler extends SQLiteOpenHelper {


    public DBHandler(Context context) {

        this(context,"my.db",null,1);
    }

    private DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table user_ (id integer,name text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
