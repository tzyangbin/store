package com.tz.store.util;

import java.io.Serializable;

/**
 * Json格式的数据进行响应
 *  注册创建响应
 * @author yang
 * @version 2023/4/9 21:52
 * @ClassName JsonResult
 * @since jdk11
 */
public class JsonResult<T> implements Serializable {
    //响应的状态码
    private Integer state;
    //描述信息
    private String message;
    //不确定用E放行表示,E表示任何数据类型
    private T data;
    //无参构造方法
    public JsonResult() {
    }
    //状态码
    public JsonResult(Integer state) {
        this.state = state;
    }
    //异常的捕获
    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    //状态码加数据
    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }
    //get/set方法
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
