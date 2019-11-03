package com.kibugs.blog.web.service;


import com.kibugs.blog.api.KbBlogTagDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Service
public class KbTagService {

    @Reference(version = "1.0.0")
    private KbBlogTagDubboService blogTagDubboService;

    /**
     * 获取top5标签（默认返回博客数量最多的5种标签）
     * @return
     */
    public List<Map<String,Integer>> getTagsForTop10(){
        return blogTagDubboService.getTagsForTop10().getData();
    }

}

