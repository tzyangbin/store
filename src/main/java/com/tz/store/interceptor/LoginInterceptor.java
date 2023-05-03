package com.tz.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义一个拦截器
 *
 * @author yang
 * @version 2023/4/13 21:57
 * @ClassName LoginInterceptor
 * @since jdk11
 * 实现HandlerInterceptor接口
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局session对象中是否有uid数据,如果有则放行,没有重定向登陆
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器(url+controller:映射)
     * @return 如果返回值ture表示放行当前的请求,如果返回值为false则表示拦截当前的请求.
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //HttpServletRequest对象来获取session对象
       Object obj= request.getSession().getAttribute("uid");
        //说明用户没有登陆过系统,则重定向login.html页面
        if (obj == null) {
            response.sendRedirect("/web/login.html");
            //结束后续的调用
            return false;
        }
        //请求放行
        return true;
    }
}
