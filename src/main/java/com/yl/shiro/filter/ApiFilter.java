package com.yl.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录后filter
 *
 * @author Liang.Yang5
 * @date 2018/9/5 14:03
 */
public class ApiFilter extends AuthFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest req, ServletResponse res) throws Exception {
        HttpServletRequest request = (HttpServletRequest) req;

        String token = request.getHeader("TOKEN");
        if (token == null || token.length() == 0) {
            token = request.getParameter("token");
            if (token == null || token.length() == 0) {
                return false;
            }
        }
        //TODO 通过token获取用户信息及权限信息

        return true;
    }
}