package com.tz.store.config;

import com.tz.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 注册处理器拦截器
 * @author yang
 * @version 2023/4/13 21:53
 * @ClassName LoginInterceptorConfigurer
 * @since jdk11
 */
//Configuration去加载当前的拦截器并进行注册
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {


    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建自定义拦截器
        HandlerInterceptor interceptor=new LoginInterceptor();
        //配置白名单:存放在一个list集合中
        List<String> patterns=new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/districts/**");
        patterns.add("/products/**");
        patterns.add("/take/take_list");
        patterns.add("/web/take.html");
        patterns.add("/takeDt/**");
        patterns.add("/web/takedt.html");
        patterns.add("/web/takelist.html");




        //将自定义拦截器进行注册,完成拦截器注册,所有请求均被拦截
        registry.addInterceptor(interceptor)
                //表示要拦截的url是什么
                .addPathPatterns("/**")
                //除了哪些不拦截,是个list的集合
                .excludePathPatterns(patterns);
    }
}
