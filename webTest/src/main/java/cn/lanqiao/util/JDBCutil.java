package cn.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCutil {
    private final  String URL = "jdbc:mysql://localhost:3306/emp?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final  String USER = "root";
    private final  String PASSWORD = "12345";

    private static Connection conn;
    private static PreparedStatement pst;
    private static ResultSet rs;

    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
    //	释放资源方法
    public static void close(Connection conn,PreparedStatement pst,ResultSet rs) {
        if(rs!=null) {
            try {
                rs.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if(pst!=null) {
            try {
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    //	封装增删改
    public static int exeChange(String sql,Object[] obj ) {
        int i = 0;

        try {
            JDBCutil jdbc = new JDBCutil();
            conn = jdbc.getConn();
            pst = conn.prepareStatement(sql);
            if(obj!=null) {
                for (int j = 1; j <= obj.length; j++) {
                    pst.setObject(j, obj[j-1]);
                }
            }
            i = pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return i;
    }
    //	封装查询
    public static ResultSet query(String sql,Object[] obj) {

        try {
            JDBCutil jdbcutil = new JDBCutil();
            conn = jdbcutil.getConn();
            pst = conn.prepareStatement(sql);
            if(obj!=null) {
                for (int i = 1; i <= obj.length; i++) {
                    pst.setObject(i, obj[i-1]);
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
}
