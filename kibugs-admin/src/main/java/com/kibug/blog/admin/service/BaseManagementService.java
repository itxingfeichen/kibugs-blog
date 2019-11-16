package com.kibug.blog.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kibugs.blog.common.CommonResponse;

/**
 * @author : chenxingfei
 * @date: 2019-11-16  23:08
 * @description: 基础服务类，用于抽取service层增删改查等功能
 */
public interface BaseManagementService<T> {

    /**
     * 创建或更新
     * @param t 需要添加或修改的实体
     * @return {@link CommonResponse}
     */
    CommonResponse createOrUpdate(T t);

    /**
     * 删除
     * @param id
     * @return {@link CommonResponse}
     */
    CommonResponse deleteById(Long id);

    /**
     * 根据id查询
     * @param id 主键
     * @return {@link CommonResponse}
     */
    CommonResponse<T> getById(Long id );

    /**
     * 分页查询
     * @param current
     * @param pageSize
     * @return
     */
    CommonResponse<IPage<T>> page(Integer current,Integer pageSize);

}
