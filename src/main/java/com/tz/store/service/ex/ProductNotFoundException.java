package com.tz.store.service.ex;

/**
 * @author yang
 * 商品数据不存在的异常
 * @version 2023/4/27 22:17
 * @ClassName ProductNotFoundException
 * @since jdk11
 */
public class ProductNotFoundException extends ServiceException {
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
