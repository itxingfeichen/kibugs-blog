package com.kibugs.blog.api;

import com.kibugs.blog.common.CommonResponse;

import java.util.List;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:02
 * @description: 博客分类dubbo服务
 */
public interface KbBlogCategoryDubboService {

    /**
     * 获取top5分类（默认返回博客数量最多的5种分类）
     * @return
     */
    CommonResponse<List<Map<String,Integer>>> getCategoryTop5();
}
