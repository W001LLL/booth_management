package com.boothmanagement.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * com.gxa.filter.CORSFilter
 * User: huangly
 * Date: 2024/12/02 16:17
 * motto:   逆水行舟不进则退
 * Description:
 * Version: v1.0
 */

/**
 * 设置跨域请求 可接收 跨域的请求
 */
@WebFilter(filterName = "CORSFilter",urlPatterns = "/*")
public class CORSFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("com.gxa.filter.CORSFilter -- 系统启动...");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        //转为 HttpServletRequest 输出请求路径
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding("utf-8");
        System.out.println("com.gxa.filter.CORSFilter -- 过滤器放行前...." + request.getRequestURL());
        HttpServletResponse response = (HttpServletResponse) res;
        response.setCharacterEncoding("utf-8");//设置字符集
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
//        //Access-Control-Allow-Origin
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT,OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
        // response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        //x-requested-with,x-token
        // response.setHeader("Access-Control-Allow-Headers", "x-requested-with,x-token");
        filterChain.doFilter(req, res);
        System.out.println("com.gxa.filter.CORSFilter -- 过滤器返回后...." + request.getRequestURL());
    }

    public void destroy() {
        System.out.println("com.gxa.filter.CORSFilter -- 系统关闭...");
    }
}

