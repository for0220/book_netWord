package org.lanqiao.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static Connection conn;
    private static PreparedStatement pst;
    private static ResultSet rs;
//          连接池连接数据库

    //          静态代码块 不需要调用 与程序一同运行
    static {

        try {
            //        创建配置文件类
            Properties properties = new Properties();
            //        读取文件
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));

            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            conn = dataSource.getConnection();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (pst != null) {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (rs != null) {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //    封装查询
    public static ResultSet query(String sql, Object[] obj) {

        try {
            pst = conn.prepareStatement(sql);
            if (obj != null) {
                for (int i = 1; i <= obj.length; i++) {
                    pst.setObject(i, obj[i - 1]);
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    //    封装增删改
    public static int exeChange(String sql, Object[] obj) {
        int i;

        try {

            pst = conn.prepareStatement(sql);
            if (obj != null) {
                for (int j = 0; j <= obj.length; j++) {
                    pst.setObject(j, obj[j - 1]);
                }
            }
            i = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }


}
