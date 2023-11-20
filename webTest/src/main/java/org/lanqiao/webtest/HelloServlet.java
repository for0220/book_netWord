package org.lanqiao.webtest;

import java.io.*;
import java.lang.reflect.Method;

import cn.lanqiao.service.imp.EmpServiceimp;
import cn.lanqiao.service.inter.Empserviceinter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.lanqiao.entity.User;

@WebServlet(name = "test", value = "/test")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String action = request.getParameter("action");

        try {
            // 使用反射可以找到和action一致的方法
            Method meth = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 调用当前action值对应的方法
            meth.invoke(this, request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Empserviceinter empserviceinter = new EmpServiceimp();
        User user = new User(0,username,password);
        Boolean boo = empserviceinter.reg(user);

//            向页面返回boo
            PrintWriter out = resp.getWriter();
            out.write(String.valueOf(boo));
            out.flush();
            out.close();

    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
    private void findOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        Empserviceinter empserviceinter = new EmpServiceimp();

        boolean boo = empserviceinter.findByName(username);

        //            向页面返回boo
        PrintWriter out = resp.getWriter();
        out.write(String.valueOf(boo));
        out.flush();
        out.close();
    }


    public void destroy() {
    }
}