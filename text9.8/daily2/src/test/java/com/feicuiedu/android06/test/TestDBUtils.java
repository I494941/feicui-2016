package com.feicuiedu.android06.test;


import daily.util.DBUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by chenyan on 2016/10/10.
 */
public class TestDBUtils {

    @Test
    public void testQueryTable() {

        String sql = "select * from user_ ";
        List<Map<String,Object>> list = DBUtils.queryTable(sql);

        for (Map<String,Object> map:list) {


            for (Map.Entry<String,Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                System.out.print(key+":"+value+",");
            }

            System.out.println();
        }
    }

    @Test
    public void testModifyTable() {

        String strSql = "insert into user_ (id,name,sex,birthday,password,description)\n" +
                "values (7,'张宗政','1','2010-09-29','ddd','我是天才2')";

        DBUtils.modifyTable(strSql);

    }
}
