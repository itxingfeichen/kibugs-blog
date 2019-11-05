package com.kibugs.blog.web.web;

import com.kibug.blog.common.entity.KbCustomer;
import com.kibug.blog.common.exception.KiBugsLoginException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : chenxingfei
 * @date: 2019-11-01  22:44
 * @description: 公共业务抽取
 */
public abstract class BaseController {


    /**
     * 获取当前登录用户信息
     *
     * @param request
     * @return
     */
    protected KbCustomer getCurrentCustomer(HttpServletRequest request) {
        return (KbCustomer) request.getSession().getAttribute("kibugs:customer");
    }

}
