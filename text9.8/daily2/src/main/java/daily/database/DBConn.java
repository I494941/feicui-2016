package daily.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by 王金飞 on 2016/10/11.
 */
public class DBConn {

    private static DBConn dbConn;

    private DBConn() {

    }

    public static DBConn getInstance() {

        if (dbConn == null) {
            dbConn = new DBConn();
        }

        return dbConn;
    }


    public Connection getConneciton() {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/wangjinfei?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";

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
}

