package contacts.android.wjf.android06.feicuiedu.com.dailysystem.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ad06-wjf on 2016/11/4.
 */
        //创建user_表
public class UserHelper extends SQLiteOpenHelper {

    public UserHelper(Context context){
        super(context, "daily.db", null, 1);
    }

    public UserHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        StringBuilder sbSql = new StringBuilder();
        sbSql.append("	CREATE TABLE user_ (			");
        sbSql.append("	u_id  int NOT NULL,             ");
        sbSql.append("	u_name  varchar(20),            ");
        sbSql.append("	u_password  varchar(20)         ");
        sbSql.append("	)                               ");

        sqLiteDatabase.execSQL(sbSql.toString());

        sbSql = new StringBuilder();
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

        sqLiteDatabase.execSQL(sbSql.toString());




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
