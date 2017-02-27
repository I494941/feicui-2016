package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.db;

/**
 * Created by ad06-wjf on 2016/11/3.
 */

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.entity.TelclassInfo;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.entity.TelnumberInfo;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.LogUtil;

/**
 * 用来做数据库文件的读取操作
 */
public class DBRead {

    /**
     * 通讯大全File
     */
    public static File telFile;

    static {
        // 默认位置
        String dbFileDir = "data/data/edu.feicui.contacts/";
        // 存储卡
        String sdcardState = Environment.getExternalStorageState();
        if (sdcardState.equals(Environment.MEDIA_MOUNTED)) {
            dbFileDir = Environment.getExternalStorageDirectory() + "/azyphone/cache";
        }
        File fileDir = new File(dbFileDir);
        fileDir.mkdirs(); // 文件目录的创建
        telFile = new File(dbFileDir, "commonnum.db");
        LogUtil.d("DBRead", "telFile dir path: " + dbFileDir);
    }

    /**
     * 检测是否存在通讯大全DB文件
     */
    public static boolean isExistsTeldbFile() {
        // 没有通讯大全
        File toFile = DBRead.telFile;
        if (!toFile.exists() || toFile.length() <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 读取telFile这个数据库文件中的classlist这个表内的数据 * @throws Exception
     */
    public static ArrayList<TelclassInfo> readTeldbClasslist() throws Exception {
        ArrayList<TelclassInfo> classListInfos = new ArrayList<TelclassInfo>();
        // 打开DB文件
        SQLiteDatabase db = null;
        // 执行查询的SQL语句 select * from classlist
        Cursor cursor = null;
        try {
            db = SQLiteDatabase.openOrCreateDatabase(telFile, null);
            cursor = db.rawQuery("select * from classlist", null);
            LogUtil.d("DBRead", "read teldb classlist size: " + cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    //idx为classlist表中电话的ID，根据idx值进行指定页面的跳转
                    int idx = cursor.getInt(cursor.getColumnIndex("idx"));

                    TelclassInfo classListInfo = new TelclassInfo(name, idx);
                    classListInfos.add(classListInfo);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        } finally {
            try {
                cursor.close();
                db.close();
            } catch (Exception e2) {
                // TODO: handle exception
                throw e2;
            }
            LogUtil.d("DBRead", "read teldb classlist end [list size]: " + classListInfos.size());
        }
        return classListInfos;
    }

    /**
     * 读取telFile这个数据库文件中的tableN这个表内的数据(商家名称和电话号码) * @throws Exception
     */
    public static ArrayList<TelnumberInfo> readTeldbTable(int idx) throws Exception {
        ArrayList<TelnumberInfo> numberInfos = new ArrayList<TelnumberInfo>();
        //idx为classlist表中电话的ID，根据idx值进行指定页面的跳转
        String sql = "select * from table" + idx;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            // 打开DB文件
            db = SQLiteDatabase.openOrCreateDatabase(telFile, null);
            // 执行查询的SQL语句select * from table + idx
            cursor = db.rawQuery(sql, null);
            LogUtil.d("DBRead", "read teldb number table size: " + cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String number = cursor.getString(cursor.getColumnIndex("number"));
                    TelnumberInfo numberInfo = new TelnumberInfo(name, number);
                    numberInfos.add(numberInfo);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        } finally {
            try {
                cursor.close();
                db.close();
            } catch (Exception e2) {
                // TODO: handle exception
                throw e2;
            }
            LogUtil.d("DBRead", "read teldb number table end [list size]: " + numberInfos.size());
        } return numberInfos;
    }


}