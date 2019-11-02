package com.kibugs.blog.web.service;


import com.kibugs.blog.api.KbBlogCategoryDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Service
public class KbCategoryService {


    @Reference(version = "1.0.0")
    private KbBlogCategoryDubboService blogCategoryDubboService;

    /**
     * 获取top5分类（默认返回博客数量最多的5种分类）
     * @return
     */
    public List<Map<String,Integer>> getCategoryTop5(){
        return blogCategoryDubboService.getCategoryTop5().getData();
    }

}

