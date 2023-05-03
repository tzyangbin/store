package com.tz.store.service.impl;

/**
 * 实现类,需要实现这个接口,并且实现抽象的方法
 *
 * @author yang
 * @version 2023/4/8 22:46
 * @ClassName UserServiceImpl
 * @since jdk11
 */

import com.tz.store.entity.User;
import com.tz.store.mapper.UserMapper;
import com.tz.store.service.IUserService;
import com.tz.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;


/**
 * 用户模块业务层的实现类
 *
 * @author tzyan
 */
@Service //@service注解:将当前类的对象交给spring来管理,自动创建对象来维护
public class UserServiceImpl implements IUserService {
    /**
     * 需要声明UserMapper的对象
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param user 用户的数据对象
     */
    @Override
    public Void reg(User user) {
        //通过user参数来获取传递过来的username
        String userName = user.getUsername();
        System.out.println("1.用户名" + userName);
        //调入findByUsername(Username)判断是否被注册过
        User result = userMapper.findByUsername(userName);
        //判断结果是否为null,则抛出用户名被占用异常
        if (result != null) {
            //抛出异常
            throw new UsernameDuplicateException("用户名被占用");
        }


        //1.获得密码,密码加密处理,MD5算法形式,串+password+串
        String oldPassword = user.getPassword();
        System.out.println("2.密码:" + oldPassword);
        //2.获取盐值(随机生成一个盐值)
        String salt = UUID.randomUUID().toString().toUpperCase();
        //补全数据:盐值的记录,为下次比较登录
        user.setSalt(salt);
        //3.将密码和盐值作为一个整体进行加密处理,忽略原有密码的强度,提升了数据的安全性
        String md5Password = getMd5Password(oldPassword, salt);
        //4.将加密之后的密码重新补全到user对象中
        user.setPassword(md5Password);


        //补全数据is_delete设置为0',
        user.setIsDelete(0);
        //补全created_user,created_time,modified_user,modified_time
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getModifiedUser());
        //获得data对象
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        //执行业务功能的实现(rows==1)
        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("用户注册过程中产生了未知的异常k");
        }
        return null;
    }

    /**
     * 用户登陆信息,在实现类中实现抽象方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 当前匹配的用户数据, 如果没有则返回null值
     */
    @Override
    public User login(String username, String password) {
        //一.先是根用户名称来查询用户的数据是否存在,如果不存在则抛出异常
        //调用mapper.userMapper.findByUsername(username)方法,返回值是个User对象
        User result = userMapper.findByUsername(username);

        if (result == null) {
            //没用数据抛异常
            throw new UserNotFoundException("用户数据不存在");
        }
        //二.检测用户密码是否匹配
        //1.先获取数据库中加密之后的密码
        String oldPassword = result.getPassword();
        //2.和用户的传递过来的密码进行比较

        //2.1先获取盐值:上一次在注册时所自动生成的盐值/在result对象中
        String salt = result.getSalt();
        //2.2 将用户的密码按照相同的md5算法的规则进行加密
        String newMd5Password = getMd5Password(password, salt);
        //3.将密码进行比较
        if (!newMd5Password.equals(oldPassword)) {
            throw new PasswordNotMatchException("用户密码错误");
        }
        //判断is_delete字段的值是否为1,表示被标记为删除
        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        //执行查询操作,调用findByUsername来查询用户的数据
        // 创建新的User对象
        User user = new User();
        // 将查询结果中的uid、username、avatar封装到新的user对象中
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());

        // 返回新的user对象
        //将当前的用户数据返回,返回的数据是为了辅助其它页面做数据展示使用
        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        // 调用userMapper的findByUid()方法，根据参数uid查询用户数据
        User result = userMapper.findByUid(uid);
        // 检查查询结果是否为null,检查查询结果中的isDelete是否为1
        if (result == null || result.getIsDelete().equals(1)) {
            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }

//
//        if (result.getIsDelete().equals(1)) {
//            // 是：抛出UserNotFoundException异常
//            throw new UserNotFoundException("用户数据不存在");
//        }

        // 原始密码和数据库中密码进行比较,从查询结果中取出盐值
        String salt = result.getSalt();
        // 将参数oldPassword结合盐值加密，得到oldMd5Password
        String oldMd5Password =
                getMd5Password(oldPassword, salt);
        // 判断查询结果中的password与oldMd5Password是否不一致
        if (!result.getPassword().contentEquals(oldMd5Password)) {
            // 是：抛出PasswordNotMatchException异常
            throw new PasswordNotMatchException("原密码错误");
        }

        // 将参数newPassword结合盐值加密，得到newMd5Password
        String newMd5Password = getMd5Password(newPassword, salt);
        // 创建当前时间对象
        Date now = new Date();
        // 调用userMapper的updatePasswordByUid()更新密码，并获取返回值
        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, username, now);
        // 判断以上返回的受影响行数是否不为1
        if (rows != 1) {
            // 是：抛出UpdateException异常
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        // 调用userMapper的findByUid()方法，根据参数uid查询用户数据
        User result = userMapper.findByUid(uid);
        // 判断查询结果是否为null,判断查询结果中的isDelete是否为1,result.getIsDelete().equals(1)
        if (result == null||result.getIsDelete()==1) {
            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }

        // 创建新的User对象,将需要的数据封装
        User user = new User();
        // 将以上查询结果中的username/phone/email/gender封装到新User对象中
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());

        // 返回新的User对象
        return user;
    }

    /**
     *user对象中的数据phone/email/gender ,手动将uid/username封装user对象中
     */
    @Override
    public void changeInfo(Integer uid, String username, User user) {
        // 调用userMapper的findByUid()方法，根据参数uid查询用户数据
        User result = userMapper.findByUid(uid);
        // 判断查询结果是否为null,判断查询结果中的isDelete是否为1,result.getIsDelete().equals(1)
        if (result == null||result.getIsDelete()==1) {
            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }

        // 向参数user中补全数据：uid
        user.setUid(uid);
        // 向参数user中补全数据修改者：modifiedUser(username)
        user.setModifiedUser(username);
        // 向参数user中补全数据修改时间：modifiedTime(new Date())
        user.setModifiedTime(new Date());
        // 调用userMapper的updateInfoByUid(User user)方法执行修改，并获取返回值
        Integer rows = userMapper.updateInfoByUid(user);
        // 判断以上返回的受影响行数是否不为1
        if (rows != 1) {
            // 是：抛出UpdateException异常
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String username, String avatar) {
        // 调用userMapper的findByUid()方法，根据参数uid查询用户数据
        User result = userMapper.findByUid(uid);
        // 检查查询结果是否为null,检查查询结果中的isDelete是否为1
        if (result == null||result.getIsDelete().equals(1)) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException("用户头像不存在");
        }

        // 创建当前时间对象
        Date now = new Date();
        // 调用userMapper的updateAvatarByUid()方法执行更新，并获取返回值
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, now);
        // 判断以上返回的受影响行数是否不为1
        if (rows != 1) {
            // 是：抛出UpdateException
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }


    /**
     * 定义一个md5算法加密处理
     */
    private String getMd5Password(String password, String salt) {
        //(进行3次加密for)
        for (int i = 0; i < 3; i++) {
            //md5加密算法的调用
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes(StandardCharsets.UTF_8)).toUpperCase();
        }
        //返回加密后的密码
        return password;
    }
}

