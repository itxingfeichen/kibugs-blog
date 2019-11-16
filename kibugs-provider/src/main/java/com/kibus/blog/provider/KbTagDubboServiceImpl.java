package com.kibus.blog.provider;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kibug.blog.common.entity.KbTag;
import com.kibugs.blog.api.KbTagDubboService;
import com.kibus.blog.mapper.KbTagMapper;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author : chenxingfei
 * @date: 2019-11-16  23:49
 * @description: 标签dubbo服务实现
 */
@Service(version = "1.0.0")
public class KbTagDubboServiceImpl extends ServiceImpl<KbTagMapper, KbTag> implements KbTagDubboService<KbTag> {



}
