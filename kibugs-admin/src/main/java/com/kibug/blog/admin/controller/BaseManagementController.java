package com.kibug.blog.admin.controller;

import com.kibug.blog.admin.service.BaseManagementService;
import com.kibugs.blog.common.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : chenxingfei
 * @date: 2019-11-16  22:45
 * @description: 基础控制类 ，用于抽取所有controller公共逻辑，如增删改查，获取当前登录用户等
 */
public abstract class BaseManagementController<T> {

    /**
     * 获取抽象服务类，需要子类进行实现
     *
     * @return
     */
    protected abstract BaseManagementService<T> getService();

    /**
     * 添加
     *
     * @param entity
     * @return
     */
    @RequestMapping("createOrUpdate")
    public CommonResponse createOrUpdate(T entity) {
        return getService().createOrUpdate(entity);
    }


}
