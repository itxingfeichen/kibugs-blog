package com.kibugs.blog.web.service;


import com.kibug.blog.common.entity.KbCategory;
import com.kibugs.blog.api.KbBlogCategoryDubboService;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class KbCategoryService {

    @Reference(version = "1.0.0")
    private KbBlogCategoryDubboService<KbCategory> blogCategoryDubboService;

    /**
     * 获取top5分类（默认返回博客数量最多的5种分类）
     * @return
     */
    public List<Map<String,Integer>> getCategoryTop5(){
        CommonResponse commonResponse = blogCategoryDubboService.getCategoryTop5();
        return (List<Map<String, Integer>>) commonResponse.getData();
    }


    /**
     * 获取所有分类
     * @return
     */
    public List<KbCategory> getAllCategories() {
        return blogCategoryDubboService.list();
    }



}

