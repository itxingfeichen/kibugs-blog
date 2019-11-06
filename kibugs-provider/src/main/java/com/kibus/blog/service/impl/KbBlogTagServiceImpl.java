package com.kibus.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kibug.blog.common.entity.KbBlogTag;
import com.kibus.blog.mapper.KbBlogTagMapper;
import com.kibus.blog.service.IKbBlogTagService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客分类映射表 服务实现类
 * </p>
 *
 * @author jannik
 * @since 2019-11-06
 */
@Service
public class KbBlogTagServiceImpl extends ServiceImpl<KbBlogTagMapper, KbBlogTag> implements IKbBlogTagService {

}
