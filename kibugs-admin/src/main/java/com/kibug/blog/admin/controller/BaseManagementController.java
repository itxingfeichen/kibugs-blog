package com.kibug.blog.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
     * 添加或修改
     *
     * @param entity
     * @return
     */
    @RequestMapping("createOrUpdate")
    public CommonResponse createOrUpdate(T entity) {
        return getService().createOrUpdate(entity);
    }


    /**
     * 根据主键删除
     * @param id
     * @return
     */
    @RequestMapping("deleteById")
    public CommonResponse deleteById(Long id) {
        return getService().deleteById(id);
    }

    /**
     * 根据主键获取对象
     * @param id
     * @return
     */
    @RequestMapping("getById")
    public CommonResponse<T> getById(Long id) {
        return getService().getById(id);
    }

    /**
     * 分页查询
     * @param current
     * @param pageSize
     * @return
     */
    @RequestMapping("getById")
    public CommonResponse<IPage<T>> page(Integer current,Integer pageSize) {
        return getService().page(current,pageSize);
    }


}
