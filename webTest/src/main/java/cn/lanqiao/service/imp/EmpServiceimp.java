package cn.lanqiao.service.imp;

import cn.lanqiao.dao.imp.EmpDaoimp;
import cn.lanqiao.dao.inter.EmpDaointer;
import cn.lanqiao.service.inter.Empserviceinter;
import org.lanqiao.entity.User;

public class EmpServiceimp implements Empserviceinter {

    @Override
    public boolean findByName(String username) {
        EmpDaointer empDaointer = new EmpDaoimp();
        User user = empDaointer.findByName(username);
        boolean boo = user!=null?true:false;
        return boo;
    }

    @Override
    public Boolean reg(User user) {
        EmpDaointer empDaointer = new EmpDaoimp();
        int i = empDaointer.reg(user);
        boolean boo = i>0?true:false;
        return boo;
    }
}
