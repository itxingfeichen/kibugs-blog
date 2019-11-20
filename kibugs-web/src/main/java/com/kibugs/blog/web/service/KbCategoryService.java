package com.kibugs.blog.web.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kibug.blog.common.entity.KbBlog;
import com.kibug.blog.common.entity.KbCategory;
import com.kibugs.blog.api.KbBlogCategoryDubboService;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


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

    private final KbBugsBlogService bugsBlogService;

    @Reference(version = "1.0.0")
    private KbBlogDubboService kbBlogDubboService;

    @Reference(version = "1.0.0")
    private KbBlogCategoryDubboService<KbCategory> blogCategoryDubboService;

    public KbCategoryService(KbBugsBlogService bugsBlogService) {
        this.bugsBlogService = bugsBlogService;
    }

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

    /**
     * 分类首页
     * @param modelAndView
     */
    public void indexPage(ModelAndView modelAndView,Long categoryId,Long tagId){

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            KbBlog blog = new KbBlog();
            blog.setCategoryId(categoryId);
            // todo 根据标签查有坑
            IPage<KbBlog> kbBlogIPage = bugsBlogService.listBlogLimit30(blog);
            modelAndView.addObject("page",kbBlogIPage);
        }).thenRunAsync(()->{
            // 获取所有分类
            CommonResponse<List<Map<String, Integer>>> allCategory = blogCategoryDubboService.getAllCategory();
            modelAndView.addObject("categories",allCategory.getData());
        });

        try {
            future.get();
        } catch (InterruptedException e) {
            log.info("分类首页加载InterruptedException异常", e);
        } catch (ExecutionException e) {
            log.info("分类首页加载ExecutionException异常", e);
        }
    }

}

