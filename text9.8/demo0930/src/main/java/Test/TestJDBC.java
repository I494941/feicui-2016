package Test;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Created by 王金飞 on 2016/9/30.
 */
public class TestJDBC {

    public static void main(String[] args) {


        StringBuffer sb = new StringBuffer();

        sb = new StringBuffer();
        sb.append(" update user_			");
        sb.append("	set name = 41, sex = 0  ");
        sb.append(" where id = 2            ");

        DBUtils.modifyUser(sb.toString());


        sb = new StringBuffer();
        sb.append(" select                        ");
        sb.append("	id,name,sex,birthday,password ");
        sb.append(" from                          ");
        sb.append("	user_                         ");
        sb.append(" where id = 1 ");

        List<Map<String,Object>> list = DBUtils.queryUserResult(sb.toString());

        for (Map<String,Object> map:list) {
            System.out.println(map.toString());
        }
    }



}
