package com.kibus.blog.service.impl;

import com.kibug.blog.common.entity.KbCategory;
import com.kibus.blog.mapper.KbCategoryMapper;
import com.kibus.blog.service.IKbCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Service
public class KbCategoryServiceImpl extends ServiceImpl<KbCategoryMapper, KbCategory> implements IKbCategoryService {

    private final KbCategoryMapper categoryMapper;

    public KbCategoryServiceImpl(KbCategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    /**
     * 获取top5分类（默认返回博客数量最多的5种分类）
     * @return
     */
    @Override
    public List<Map<String, Integer>> getCategoryTop5() {
        return categoryMapper.getCategoryTop5();
    }


    /**
     * 获取所有分类
     * @return
     */
    @Override
    public List<Map<String, Integer>> getAllCategory() {
        return categoryMapper.getAllCategory();
    }
}
