package com.yl.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Liang.Yang5
 * @date 2018/9/4 21:53
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginDo", method = RequestMethod.POST)
    public String loginDo(HttpServletRequest request, HttpSession session) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(userName);
        System.out.println(password);
        //获取当前登录用户
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(new UsernamePasswordToken(userName, password, false));
        } catch (AuthenticationException ex) {
            System.out.println(ex.getMessage());
            session.setAttribute("message_login_captcha", "用户名或密码错误");
            return "redirect:/index";
        }
        return "redirect:/index";
    }

    @RequiresPermissions("bbbaaa")
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}