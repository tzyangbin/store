package com.tz.store.mapper;

import com.tz.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 用户模块的持久层接口
 *
 * @author tzyangbin
 * @version 2023/4/6 23:32
 * @since jdk11
 */
//mapper
public interface UserMapper {
    /**
     * 插入用户数据
     *
     * @param user 用户数据
     * @return 受影响的行数(增, 删, 改都受影响的行数作为返回值, 可根据返回值来判断是否执行)
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     *
     * @param username 用户名
     * @return 如果找到对应的用户则返回用户的数据, 没有找到返回null值
     */

    User findByUsername(String username);

    /**
     * 根据用户的uid来修改用户密码
     *
     * @param uid          用户的id
     * @param password
     * @param modifiedUser
     * @param modifiedTime
     * @return 返回受影响的行数
     */
    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);

    /**
     * 根据用户的id查询用户的数据
     *
     * @param uid 用户的id
     * @return 如果找到返回对象, 反之返回null值
     */
    User findByUid(Integer uid);

    /**
     * 根据uid更新用户资料
     *
     * @param user 封装了用户id和新个人资料的对象
     * @return 受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * @param ("sql映射文件中#{}占位符的变量名"):解决的问题,当sql语句的点位符 和映射的接口方法不一致时,需要将某个参数强行注入到某个占位符变量时
     *                                                根据uid更新用户的头像
     * @param uid                                     用户的id
     * @param avatar                                  新头像的路径
     * @param modifiedUser                            修改执行人
     * @param modifiedTime                            修改时间
     * @return 受影响的行数
     */
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);
}


