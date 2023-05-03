package com.tz.store.service.ex;

/**
 * 业务层异常的基类
 *
 * @author yang
 * @version 2023/4/8 22:12
 * @ClassName ServiceException
 * @since jdk11
 * 远行时产生,抛异常 throws new ServiceException("业务层产生未知异常")
 */
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
