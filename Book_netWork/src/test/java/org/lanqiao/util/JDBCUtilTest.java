package org.lanqiao.util;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilTest {

    @Test
    void query() {
            try {
                ResultSet rs = JDBCUtil.query("select * from users",null);
                while (rs.next()){
                    System.out.println(rs.getString("username"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}