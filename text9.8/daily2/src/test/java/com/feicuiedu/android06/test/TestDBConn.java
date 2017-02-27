package com.feicuiedu.android06.test;


import daily.database.DBConn;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by chenyan on 2016/10/10.
 */
public class TestDBConn {

    @Test
    public void testGetConnection () {


       Connection con = DBConn.getInstance().getConneciton();

        if (con != null) {
            System.out.println("数据库连接成功");
        }
        else {
            System.out.println("数据库连接失败");
        }
    }
}
