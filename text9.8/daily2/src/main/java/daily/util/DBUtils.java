package daily.util;

import daily.database.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王金飞 on 2016/10/11.
 */
public class DBUtils {

    // 新增，修改，删除的操作
    public static void modifyTable(String strSql) {
        Connection connection = DBConn.getInstance().getConneciton();
        Statement st = null;
        try {
            st = connection.createStatement();
            st.executeUpdate(strSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 查询的操作
    public static List<Map<String, Object>> queryTable(String strSql) {

        Connection connection = DBConn.getInstance().getConneciton();
        List<Map<String, Object>> lstResult = new ArrayList<Map<String, Object>>();

        try {

            List<String> lstColumnNames = new ArrayList<String>();

            ResultSet rs = connection.createStatement().executeQuery(strSql);

            ResultSetMetaData rsm = rs.getMetaData();

            int colCount = rsm.getColumnCount();
            for (int i = 0; i < colCount; i++) {

                String columnName = rsm.getColumnName(i + 1);
                lstColumnNames.add(columnName.toLowerCase());
            }

            while (rs.next()) {

                LinkedHashMap<String, Object> resMap = new LinkedHashMap<String, Object>();
                for (String columnName : lstColumnNames) {
                    Object obj = rs.getObject(columnName);
                    resMap.put(columnName, obj);
                }

                lstResult.add(resMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lstResult;
    }
}
