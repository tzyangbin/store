package com.tz.store.service;

import com.tz.store.entity.User;

/**
 * @author tzyangbin
 * @version 2023/4/8 22:43
 * @since jdk11
 * 用户模块业务层接口
 */
public interface IUserService {
    /**
     * 用户注册方法
     *
     * @param user 用户的数据对象
     */
    Void reg(User user);


    /**
     * 编写方法,登陆login(string username ,string password)
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回值(展示用户信息) 当前匹配的用户数据,如果没有则返回null值
     */
    User login(String username, String password);

    /**
     * 修改密码
     *
     * @param uid         当前登录的用户id
     * @param username    用户名
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    /**
     * 获取当前登录的用户的信息
     *
     * @param uid 当前登录的用户的id
     * @return 当前登录的用户的信息
     */
    User getByUid(Integer uid);

    /**
     * 修改用户资料
     *
     * @param uid      当前登录的用户的id
     * @param username 当前登录的用户名
     * @param user     用户的新的数据
     */
    void changeInfo(Integer uid,
                    String username,
                    User user);

    /**
     * 修改用户头像
     *
     * @param uid      当前登录的用户的id
     * @param username 当前登录的用户名
     * @param avatar   用户的新头像的路径
     */
    void changeAvatar(Integer uid,
                      String username,
                      String avatar);

}


