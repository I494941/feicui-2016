package com.feicuiedu.android.servicesdemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.feicuiedu.android.servicesdemo", appContext.getPackageName());
    }

    @Test
    public void testQuery() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        String strUri = "content://com.feicuiedu.android.contentproviderdemo/MyContentProvider";
        Uri uri = Uri.parse(strUri);

        ContentResolver cr = appContext.getContentResolver();
        ContentValues contentValues = new ContentValues();
        /*contentValues.put("id","1");
        contentValues.put("name","sky");*/

        contentValues.put("id","2");
        contentValues.put("name","moon");

        // Cursor cursor = cr.query(uri,null,"id=? ",new String[]{"1"},null);
        Cursor cursor = cr.query(uri,null,null,null,null);

        while(cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));

            Log.d("query",id+":"+name);
        }

        cursor.close();

    }
}
