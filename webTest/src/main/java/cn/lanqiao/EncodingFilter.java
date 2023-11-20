package cn.lanqiao;

import jakarta.servlet.*;

import java.io.IOException;


public class EncodingFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("初始化..........");
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行..........");
        //        设置头部请求信息
        servletResponse.setContentType("text/html; charset="+encoding);
        servletResponse.setCharacterEncoding(encoding);

        servletRequest.setCharacterEncoding(encoding);

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("销毁..........");
    }
}
