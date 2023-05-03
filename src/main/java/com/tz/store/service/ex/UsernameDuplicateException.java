package com.tz.store.service.ex;

/**
 * @author yang
 * @version 2023/4/8 22:35
 * @ClassName UsernameDuplicatedException
 * @since jdk11
 * 用户名被占用异常
 */
public class UsernameDuplicateException extends ServiceException{
    public UsernameDuplicateException() {
        super();
    }

    public UsernameDuplicateException(String message) {
        super(message);
    }

    public UsernameDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicateException(Throwable cause) {
        super(cause);
    }

    protected UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
