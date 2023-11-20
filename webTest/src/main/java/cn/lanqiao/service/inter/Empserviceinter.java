package cn.lanqiao.service.inter;

import org.lanqiao.entity.User;

public interface Empserviceinter {
    boolean findByName(String username);

    Boolean reg(User user);
}
