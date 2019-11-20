package com.kibus.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kibug.blog.common.entity.KbCategory;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
public interface IKbCategoryService extends IService<KbCategory> {
    /**
     * 获取top5分类（默认返回博客数量最多的5种分类）
     * @return
     */
    List<Map<String,Integer>> getCategoryTop5();

    /**
     * 获取所有分类
     * @return
     */
    List<Map<String, Integer>> getAllCategory();

}
