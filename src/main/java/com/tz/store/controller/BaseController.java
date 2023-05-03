package com.tz.store.controller;

import com.tz.store.controller.ex.*;
import com.tz.store.service.ex.*;
import com.tz.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 优化
 *
 * @author yang
 * @version 2023/4/9 22:39
 * @ClassName BaseController
 * @since jdk11
 * 控制层类的基类,异常的捕获处理
 */
public class BaseController {
    //操作成功状态吗
    public static final int OK = 200;

    /**
     * 从HttpSession对象中获取uid
     *
     * @param session HttpSession对象
     * @return 当前登录的用户的id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 从HttpSession对象中获取用户名
     *
     * @param session HttpSession对象
     * @return 当前登录的用户名
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    //操作不成功
    //请求处理方法,这个方法的返回值需要传递给前端的数据
    //自动将异常对象传递给此方法的参数列表上
    //当前项目中产生的异常,被统一拦截到此方法中,这个方法此时就冲当的是请求处理方法,方的的返回值直接给到前端

    /**
     * @ExceptionHandler用于统一处理方法抛出的异常
     */
    @ExceptionHandler({ServiceException.class, FileUploadException.class}) //用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
            result.setMessage("收货地址超出上限");
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("收货地址");
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("用户的收货地址数据访问异常");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
            result.setMessage("收货地址数据非法访问异常");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生未知异常");
        } else if (e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("用户数据不存在的异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("用户的密码错误异常");
        } else if (e instanceof UpdateException) {
            result.setState(5003);
            result.setMessage("更新数据时产生末知异常");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }

        return result;
    }
}
