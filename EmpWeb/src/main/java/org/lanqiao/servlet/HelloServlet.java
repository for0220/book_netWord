package org.lanqiao.servlet;

import cn.hutool.captcha.LineCaptcha;
import com.alibaba.fastjson.JSONArray;
import org.lanqiao.entity.User;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/test")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //获取action的值
        String action = req.getParameter("action");
        //反射
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
        boolean boo = false;
        if (username.equals("admin")){
            boo=true;
        }
        PrintWriter out = resp.getWriter();
        out.write(String.valueOf(boo));
        out.flush();
        out.close();
    }
    private void jsonServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u1= new User(101,"张三","123456");
        User u2= new User(102,"张四","123456");
        User u3= new User(103,"张五","123456");
        List<User> list = new ArrayList<User>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        //调用Json类
        JSONArray json = new JSONArray(list);
        String res_json = json.toJSONString();

        PrintWriter out = resp.getWriter();
        out.write(res_json);
        out.flush();
        out.close();
    }
    private void codeImgProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用Hutool工具类 生成验证码             宽，高，字符数，线段数
        LineCaptcha lineCaptcha = new LineCaptcha(100,30,4,10);
        lineCaptcha.createCode();
        String code = lineCaptcha.getCode();

        req.getSession().setAttribute("code",code);
//        设置格式
        resp.setContentType("images/jpeg");
//        浏览器无缓存
        resp.setHeader("Paragma","No-cache");
        lineCaptcha.write(resp.getOutputStream());
        resp.getOutputStream().close();

    }
    private void yanzhen(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = String.valueOf(req.getSession().getAttribute("code"));

        PrintWriter out = resp.getWriter();
        out.write(code);
        out.flush();
        out.close();
    }
}