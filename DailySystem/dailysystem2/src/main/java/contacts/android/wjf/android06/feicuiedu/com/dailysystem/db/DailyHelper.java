package contacts.android.wjf.android06.feicuiedu.com.dailysystem.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ad06-wjf on 2016/11/4.
 */
        //创建daily_表
public class DailyHelper extends SQLiteOpenHelper {

    public DailyHelper(Context context){
        super(context, "daily.db", null, 1);
    }

    public DailyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
/*        StringBuilder sbSql = new StringBuilder();
        sbSql.append("	CREATE TABLE daily_ (			 ");
        sbSql.append("	d_id  int NOT NULL,              ");
        sbSql.append("	d_name  varchar(20),             ");
        sbSql.append("	d_create_date  varchar(20),      ");
        sbSql.append("	d_create_id  varchar(20),        ");
        sbSql.append("	d_should_finished  varchar(20),  ");
        sbSql.append("	d_have_finished  varchar(20),    ");
        sbSql.append("	d_unfinished_reason  varchar(20),");
        sbSql.append("	d_queson_and_answer  varchar(20),");
        sbSql.append("	d_next_day_plan  varchar(20)     ");
        sbSql.append("	)                               ");

        sqLiteDatabase.execSQL(sbSql.toString());*/
    }
}
