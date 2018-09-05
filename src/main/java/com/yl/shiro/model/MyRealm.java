package com.yl.shiro.model;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Liang.Yang5
 * @date 2018/9/4 21:32
 */
public class MyRealm extends AuthorizingRealm {

    public MyRealm() {
        setName("myRealm");
    }

    /**
     * 获取权限(登录成功后调用)
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //TODO 根据用户信息查询对应的权限信息
//        principals.fromRealm(getName()).iterator().next();
        Set<String> permissions = new HashSet<>();
        permissions.add("aaaa");
        permissions.add("bbbb");
        permissions.add("cccc");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 登录验证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userNameToken = (UsernamePasswordToken) token;

        String userName = userNameToken.getUsername();
        String password = new String(userNameToken.getPassword());
        if ("Admin".equalsIgnoreCase(userName) && "123123".equals(password)) {
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, password, getName());
            return authenticationInfo;
        }
        throw new AuthenticationException("username or password is error!");
    }
}