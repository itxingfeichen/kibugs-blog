package com.kibus.blog.service.impl;

import com.kibug.blog.common.entity.KbCategory;
import com.kibus.blog.mapper.KbCategoryMapper;
import com.kibus.blog.service.IKbCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
