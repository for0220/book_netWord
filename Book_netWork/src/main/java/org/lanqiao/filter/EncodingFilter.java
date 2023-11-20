package org.lanqiao.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private static String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
//        设置对客户端请求进行重新编码的编码
        req.setCharacterEncoding(encoding);
//        指定对服务器响应进行重新编码的编码
        res.setCharacterEncoding(encoding);
//        指定对服务器响应进行重新编码的编码。
        res.setContentType("text/html; charset="+encoding);

        if (encoding.equals("UTF-8")){
            filterChain.doFilter(req,res);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
