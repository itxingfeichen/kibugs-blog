package com.kibugs.blog.api;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author : chenxingfei
 * @date: 2019-11-17  00:04
 * @description: 抽取基础服务接口
 */
public abstract class AbstractBaseDubboService<T>  {

    /**
     * 服务接口
     * @return IService
     */
    protected abstract IService<T> getService();




}
