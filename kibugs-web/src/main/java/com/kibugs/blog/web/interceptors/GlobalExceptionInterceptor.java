package com.kibugs.blog.web.interceptors;

import com.kibug.blog.common.exception.KiBugsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jannik
 * @version v1.0.0
 * @description 全局异常拦截器
 * @date 2019-11-24 11:02
 **/
@RestControllerAdvice(basePackages = "com.kibugs.blog.web.interceptors")
public class GlobalExceptionInterceptor {

    /**
     * @methodName: resolveException
     * @description: 处理自定义异常
     * @param: [e] 异常
     * @return: org.springframework.web.servlet.ModelAndView
     * @date: 2019-11-24
     **/
    @ExceptionHandler(KiBugsException.class)
    public ModelAndView resolveException(Exception e) {

        return new ModelAndView("/error/500");

    }
}
