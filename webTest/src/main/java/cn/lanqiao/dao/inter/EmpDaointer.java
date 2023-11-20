package cn.lanqiao.dao.inter;

import org.lanqiao.entity.User;

public interface EmpDaointer {
    User findByName(String username);

    int reg(User user);
}
