package com.tz.store.service.ex;

/**
 * 打药信息没有
 *
 * @author yang
 * @version 2023/5/3 22:34
 * @ClassName TakeNotFoundException
 * @since jdk11
 */
public class TakeNotFoundException extends  ServiceException{
    public TakeNotFoundException() {
        super();
    }

    public TakeNotFoundException(String message) {
        super(message);
    }

    public TakeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TakeNotFoundException(Throwable cause) {
        super(cause);
    }

    protected TakeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
