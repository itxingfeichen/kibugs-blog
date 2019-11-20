package com.kibugs.blog.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kibugs.blog.common.CommonResponse;

import java.util.List;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-11-03  08:02
 * @description: 博客标签dubbo服务
 */
public interface KbBlogTagDubboService<T> extends IService<T> {

    /**
     * 获取top5标签（默认返回博客数量最多的5种标签）
     * @return
     */
    CommonResponse<List<Map<String,Integer>>> getTagsForTop10();

    /**
     * 获取所有标签
     * @return
     */
    CommonResponse<List<Map<String,Integer>>> getAllTags();
}
