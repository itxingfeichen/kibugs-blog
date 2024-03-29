package com.kibus.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kibug.blog.common.entity.KbBlog;
import com.kibus.blog.mapper.KbBlogMapper;
import com.kibus.blog.service.IKbBlogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jannik
 * @since 2019-10-31
 */
@Service
public class KbBlogServiceImpl extends ServiceImpl<KbBlogMapper, KbBlog> implements IKbBlogService {

}
