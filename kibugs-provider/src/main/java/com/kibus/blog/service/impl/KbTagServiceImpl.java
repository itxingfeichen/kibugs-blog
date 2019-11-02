package com.kibus.blog.service.impl;

import com.kibug.blog.common.entity.KbTag;
import com.kibus.blog.mapper.KbTagMapper;
import com.kibus.blog.service.IKbTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Service
public class KbTagServiceImpl extends ServiceImpl<KbTagMapper, KbTag> implements IKbTagService {

}
