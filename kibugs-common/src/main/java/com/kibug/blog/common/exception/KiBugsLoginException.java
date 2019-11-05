package com.kibug.blog.common.exception;

/**
 * @Author chenxingfei
 * @Description 登录异常
 * @Date 2019/11/5 18:05
 **/
public class KiBugsLoginException extends RuntimeException {

    public KiBugsLoginException() {
        super();
    }

    public KiBugsLoginException(String message) {
        super(message);
    }

    public KiBugsLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public KiBugsLoginException(Throwable cause) {
        super(cause);
    }

    protected KiBugsLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
