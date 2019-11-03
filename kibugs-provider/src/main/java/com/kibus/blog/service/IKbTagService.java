package com.kibus.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kibug.blog.common.entity.KbTag;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
public interface IKbTagService extends IService<KbTag> {

    /**
     * 获取top5标签（默认返回博客数量最多的10种标标签）
     * @return
     */
    List<Map<String,Integer>> getTagsForTop10();

}
