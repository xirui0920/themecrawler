package edu.qpp.crawler.crawler.dataprocess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xirui on 2017/4/13.
 *  test
 */
public class Dao {

    private static volatile Connection conn = null;
    private static final String url = "jdbc:mysql://localhost:3306/ThemeCrawler?useUnicode=true&characterEncoding=UTF8&useSSL=false";
    private static final String username = "root";
    private static final String password = "xirui";

    private Dao() {}

    public static synchronized Connection getCon(){
        if (conn == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url,username,password);
                return conn;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


}
