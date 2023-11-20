package cn.lanqiao.dao.imp;

import cn.lanqiao.dao.inter.EmpDaointer;
import cn.lanqiao.util.JDBCutil;
import org.lanqiao.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDaoimp implements EmpDaointer {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public User findByName(String username) {
        User u = null;
        try {
            String sql = "select * from user where userName = ?";
            Object [] obj ={username};
            rs = JDBCutil.query(sql,obj);
            while(rs.next()){
                u = new User(rs.getInt("id"),
                         rs.getString("userName"),
                         rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
       return u;
    }

    @Override
    public int reg(User user) {
        int i = 0;
        try {
            String sql = "insert into user (userName,password) values(?,?)";
            Object[] obj = {user.getUserName(),user.getPassword()};
            i = JDBCutil.exeChange(sql,obj);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
