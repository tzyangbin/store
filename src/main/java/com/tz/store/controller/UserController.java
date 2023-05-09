package com.tz.store.controller;

import com.tz.store.controller.ex.*;
import com.tz.store.entity.User;
import com.tz.store.service.IUserService;
import com.tz.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 处理请求
 *
 * @author yang
 * @version 2023/4/9 22:09
 * @ClassName UserController
 * @since jdk11
 */
//@Controller表示当前类交给springboot管理
//@Controller
@RestController //Controller+ResponseBody
@RequestMapping("users")
//优化关系,继承基类
public class UserController extends BaseController {
    //依赖于业务层接口
    @Autowired
    private IUserService userService;




    @RequestMapping("reg")
    //@ResponseBody 表示此方法响应结果以json格式进行数据响应给到前端
    public JsonResult<Void> reg(User user) {
        //调用userService方法
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);


        //登录成功后，将uid和username存入到HttpSession中
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        System.out.println("Session中的uid:" + getUidFromSession(session));
        System.out.println("Session中的username:" + getUsernameFromSession(session));
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("chang_password")
    public JsonResult<Void> changePassword(String oldPassword,
                                           String newPassword,
                                           HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        // 从HttpSession对象中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行获取数据
        User data = userService.getByUid(uid);
        // 响应成功和数据
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        // 从HttpSession对象中获取uid和username,User user 对象中有四部分数据:username,phone,gender
        //uid 数据需要再次封装到user对象中
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行修改用户资料
        userService.changeInfo(uid, username, user);
        // 响应成功
        return new JsonResult<Void>(OK);
    }

    /**
     * 设置上传文件大小的上限值(10MB)
     */
    public static final int AVATAR_MAX_SIZE = 1 * 1024 * 1024;
    /**
     * 允许上传的头像的文件类型
     */
    public static final List<String> AVATAR_TYPES =
            new ArrayList<>();

    /** 初始化允许上传的头像的文件类型 */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }

    /**
     * MultipartFile接口是springMVC提供的接口,这个接口为我们包装了获取文件类型的数据(任何类型的file都可以),
     * springBoot整合了springMVC,只需要在处理请求的方法参数列表上声明一个参数为MultipartFile的参数,
     * 然后springboot自动将传递给服务的文件数据赋值给这个参数.
     *
     * @param session
     * @param @RequestParam 表示请求中的参数,将请求中的参数注入给请求处理的某个参数上,
     *                      如果名称不一致可以使用@RequestParam注解进行标记和映射.
     * @return
     */
    @PostMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session,
                                           @RequestParam("file") MultipartFile file) {
        {
            // 判断上传的文件是否为空
            if (file.isEmpty()) {
                // 是：抛出异常
                throw new FileEmptyException("上传的头像文件为空");
            }

            // 判断上传的文件大小是否超出限制值
            if (file.getSize() > AVATAR_MAX_SIZE) {
                // getSize()：返回文件的大小，以字节为单位
                // 是：抛出异常
                throw new FileSizeException("不允许上传超过" + (AVATAR_MAX_SIZE / 1024 * 1024) + "MB的头像文件");
            }

            // 判断上传的文件类型是否是规定类型,getContentType获取文件类型text/html
            String contentType = file.getContentType();
            // boolean contains(Object o)：当前列表若包含某元素，返回结果为true；若不包含该元素，返回结果为false
            if (!AVATAR_TYPES.contains(contentType)) {
                // 是：抛出异常
                throw new FileTypeException("不支持使用该类型的文件作为头像，允许的文件类型：" + AVATAR_TYPES);
            }

            // 获取当前项目的绝对磁盘路径,创建文件夹upload
            String parent = session.getServletContext().getRealPath("upload");
            //打印parent
            System.out.println(parent);
            // 保存头像文件的文件夹,file对象指向路径,file是不存在
            File dir = new File(parent);
            if (!dir.exists()) {
                //创建目录
                dir.mkdirs();
            }

            // file.getOriginalFilename获取文件名称,保存的头像文件的文件名
            String originalFilename = file.getOriginalFilename();
            System.out.println("文件名称:" + originalFilename);
//            String suffix = "";
            int beginIndex = originalFilename.lastIndexOf(".");
//            if (beginIndex > 0) {
            String suffix = originalFilename.substring(beginIndex);
//            }
            //UUID生成一个新的字符串
            String filename = UUID.randomUUID().toString().toUpperCase() + suffix;

            // 创建文件对象，表示保存的头像文件
            File dest = new File(dir, filename);
            //  将参数file中的数据写入到这个空文件中,transferTo将file文件中的数据写入到dest文件中
            try {
                file.transferTo(dest);
            } catch (IllegalStateException e) {
                // 抛出异常
                throw new FileStateException("文件状态异常，可能文件已被移动或删除");
            } catch (IOException e) {
                // 抛出异常
                throw new FileUploadIOException("上传文件时读写错误，请稍后重新尝试");
            }

            // 头像路径
            String avatar = "/upload/" + filename;
            // 从Session中获取uid和username
            Integer uid = getUidFromSession(session);
            String username = getUsernameFromSession(session);
            // 将头像写入到数据库中,头像的路径
            userService.changeAvatar(uid, username, avatar);

            // 返回成功头像路径
            return new JsonResult<String>(OK, avatar);
        }
    }

// 优化前的代码
//   @RequestMapping("reg")
//     @ResponseBody //表示此方法响应结果以json格式进行数据响应给到前端
//    public JsonResult<Void> reg(User user){
//        //创建响应结果对象方法
//        JsonResult<Void> result= new JsonResult<>();
//        //调用userService方法
//        try {
//            userService.reg(user);
//            result.setState(200);
//            result.setMessage("用户注册成功");
//        }
//        catch (UsernameDuplicatedException e) { //业务层定义的异常
//            result.setState(4000);
//            result.setMessage("用户名被占用");
//        }catch (InsertException e) {
//            result.setState(5000);
//            result.setMessage("注册时产生未知异常");
//        }
//        return result;
//    }

}
