package com.kibus.blog.service.impl;

import com.kibug.blog.common.entity.KbBlogCategory;
import com.kibus.blog.mapper.KbBlogCategoryMapper;
import com.kibus.blog.service.IKbBlogCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客分类映射表 服务实现类
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Service
public class KbBlogCategoryServiceImpl extends ServiceImpl<KbBlogCategoryMapper, KbBlogCategory> implements IKbBlogCategoryService {

}
