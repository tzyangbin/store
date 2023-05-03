package com.tz.store.service;

import com.tz.store.entity.User;
import com.tz.store.mapper.UserMapper;
import com.tz.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yang
 * @version 2023/4/7 22:24
 * @ClassName UserMapperTest
 * @since jdk11
 */
//SpringBootTest表示标注当前的类是一测试类，不会被打包
@SpringBootTest
//RunWith：表示启动这个单元测试类，需要传递一个参数，SpringRunner.class实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {
    // userMapper报错，idea是有检测功能，接口是不能够直接创建bean
    @Autowired
    private IUserService userService;

    /**
     * 单元测试方法，可以独立远行
     * 1.@Test注解，2返回值void，3方法参数不指定任何类型，4方法访问是public
     */
    //插入方法
    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("yang05");
            user.setPassword("123456");
            userService.reg(user);
            System.out.println("插入成功");
        } catch (ServiceException e) {
            //先获取类的对象,再获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
            String username = "yang05";
            String password = "123456";
            User user = userService.login(username, password);
            System.out.println("登录成功！" + user);
    }

    @Test
    public void changePassword() {
            Integer uid = 19;
            String username = "管理员";
            String oldPassword = "123456";
            String newPassword = "888888";
            userService.changePassword(uid, username, oldPassword, newPassword);
            System.out.println("密码修改成功！");

    }

    @Test
    public void getByUid() {
            Integer uid = 19;
            User user = userService.getByUid(uid);
            System.out.println(user);
    }

    @Test
    public void changeInfo() {
            Integer uid = 19;
            String username = "管理员";
            User user = new User();
            user.setPhone("13914405808");
            user.setEmail("tzyangb@163.com");
            user.setGender(0);
            userService.changeInfo(uid, username, user);
            System.out.println("修改成功");
    }

    @Test
    public void changeAvatar() {
            Integer uid = 19;
            String username = "头像管理员";
            String avatar = "/upload/avatar.png";
            userService.changeAvatar(uid, username, avatar);
            System.out.println("修改成功");
    }


}
