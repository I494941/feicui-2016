package Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王金飞 on 2016/9/30.
 */
public class DBUtils {

    private static Connection getConnection() {

        Map<String,String> configMap = FileUtils.getConfigMap();

        String driver = configMap.get("driver");
        String url = configMap.get("url");
        String username = configMap.get("username");
        String password = configMap.get("password");

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        // 注册驱动
        try {
            Class.forName(driver);
            // 根据驱动获得连接
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 查询User表的方法
     * @param sql 传入的查询语句
     * @return 查询出来的结果集
     */
    public static List<Map<String,Object>> queryUserResult(String sql) {

        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        try {
            connection = getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);


            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                java.util.Date birthday = rs.getDate("birthday");
                int sex = rs.getInt("sex");
                String password = rs.getString("password");


                Map<String,Object> tmpMap= new HashMap<String,Object>();

                tmpMap.put("id", id);
                tmpMap.put("name", name);
                tmpMap.put("birthday", birthday);
                tmpMap.put("sex", sex);
                tmpMap.put("password", password);


                list.add(tmpMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                rs.close();
                st.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    /**
     * 新增，修改，删除的方法
     * @param sql 新增或者修改或者删除的语句
     */
    public static void modifyUser(String sql) {

        Connection connection = null;
        Statement st = null;

        try {

            connection = getConnection();
            st = connection.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                st.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
