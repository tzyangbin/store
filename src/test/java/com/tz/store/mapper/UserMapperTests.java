package com.tz.store.mapper;

import com.tz.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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
public class UserMapperTests {
    // userMapper报错，idea是有检测功能，接口是不能够直接创建bean
    @Autowired
    private UserMapper userMapper;

    /**
     * 单元测试方法，可以独立远行
     * 1.@Test注解，2返回值void，3方法参数不指定任何类型，4方法访问是public
     */
    //插入方法
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("yy");
        user.setPassword("123456");

        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void select() {
        User user = userMapper.findByUsername("yy");
        System.out.println(user);
    }
    @Test
    public void updatePasswordByUid() {
        Integer uid = 1;
        String password = "123";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);

    }

    @Test
    public void findByUid() {
        Integer uid = 1;
        User result = userMapper.findByUid(uid);
        System.out.println("查找成功:"+result.getPassword());
    }

    @Test
    public void updateInfoByUid(){
        User user=new User();
        Integer uid = 19;
        String phone = "13914405808";
        String email="tzyangb@163.com";
        Integer gender=1;
        user.setUid(uid);
        user.setPhone(phone);
        user.setEmail(email);
        user.setGender(gender);
        Integer rows =userMapper.updateInfoByUid(user);
        System.out.println("更新成功:" + rows+"条信息");
    }

    @Test
    public void updateAvatarByUid() {
        Integer uid = 19;
        String avatar = "/upload/avatar.png";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
        System.err.println("rows=" + rows);
    }


}
