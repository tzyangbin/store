package com.tz.store.service.ex;

/**
 * 插入操作的时候,服务器,数据库宕机,处于插入过程中产生的异常
 *
 * @author yang
 * @version 2023/4/8 22:38
 * @ClassName InsertException
 * @since jdk11
 */
public class InsertException extends ServiceException{
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
