package com.yl.shiro.filter;

import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Liang.Yang5
 * @date 2018/9/5 10:59
 */
public abstract class AuthFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest req, ServletResponse res, Object mappedValue) throws Exception {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        //设置响应头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "TOKEN,Accept,Content-Type, x-requested-with, X-Custom-Header,Cache-Control");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return false;
    }
}