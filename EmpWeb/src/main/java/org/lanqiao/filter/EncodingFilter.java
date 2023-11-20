package org.lanqiao.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       //获取web.xml
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        //设置编码格式
        req.setCharacterEncoding(encoding);
        res.setCharacterEncoding(encoding);

        res.setContentType("text/html; charset="+encoding);

        filterChain.doFilter(req,res);
    }

}
