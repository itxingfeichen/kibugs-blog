package com.kibus.blog.service.impl;

import com.kibus.blog.entity.KbComment;
import com.kibus.blog.mapper.KbCommentMapper;
import com.kibus.blog.service.IKbCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Service
public class KbCommentServiceImpl extends ServiceImpl<KbCommentMapper, KbComment> implements IKbCommentService {

}
