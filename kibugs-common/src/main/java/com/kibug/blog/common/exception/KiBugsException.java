package com.kibug.blog.common.exception;

/**
 * @author jannik
 * @version v1.0.0
 * @description 自定义异常
 * @date 2019-11-24 11:30
 **/
public class KiBugsException extends RuntimeException {

    public KiBugsException() {
        super();
    }

    public KiBugsException(String message) {
        super(message);
    }

    public KiBugsException(String message, Throwable cause) {
        super(message, cause);
    }

    public KiBugsException(Throwable cause) {
        super(cause);
    }

    protected KiBugsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
