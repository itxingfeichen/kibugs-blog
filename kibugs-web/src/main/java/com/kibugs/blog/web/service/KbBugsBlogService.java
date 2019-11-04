package com.kibugs.blog.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibug.blog.common.entity.KbBlog;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/10/31  22:31
 * @description: 博客业务处理类
 **/
@Service
@Slf4j
public class KbBugsBlogService {

    @Reference(version = "1.0.0")
    private KbBlogDubboService kbBlogDubboService;

    private final KbCategoryService categoryService;

    private final KbTagService tagService;

    public KbBugsBlogService(KbCategoryService categoryService, KbTagService tagService) {
        this.categoryService = categoryService;
        this.tagService = tagService;
    }

    public KbBlogDTO getBlogById(Long id) {
        CommonResponse<KbBlogDTO> one = kbBlogDubboService.getOne(id);
        return one.getData();
    }

    /**
     * 分页获取首页数据
     *
     * @param modelAndView
     * @return
     */
    public void indexPage(ModelAndView modelAndView) {
        CompletableFuture<Void> blogAndCategoryTop5Future = CompletableFuture.runAsync(() -> {
            IPage<KbBlog> page = new Page<>(1, 30);
            CommonResponse<IPage<KbBlog>> commonResponse = kbBlogDubboService.indexPage(page);
            IPage<KbBlog> data = commonResponse.getData();
            modelAndView.addObject("page", data);
        }).thenRunAsync(() -> modelAndView.addObject("categoryTop5", categoryService.getCategoryTop5())).whenComplete((r, e) -> {
            if (e == null) {
                log.info("首页加载完成");
            } else {
                log.info("首页加载异常", e);
            }
        });
        CompletableFuture<Void> tagTop10AndRecommendFuture = CompletableFuture.runAsync(() -> modelAndView.addObject("tagTop10", tagService.getTagsForTop10())).thenRunAsync(() -> {
            List<KbBlog> data = kbBlogDubboService.indexRecommend().getData();
            modelAndView.addObject("recommends", data);
        }).whenComplete((r, e) -> {
            if (e == null) {
                log.info("首页加载完成");
            } else {
                log.info("首页加载异常", e);
            }
        });
        try {
            CompletableFuture.allOf(blogAndCategoryTop5Future,tagTop10AndRecommendFuture).get();
        } catch (InterruptedException e) {
            log.info("首页加载InterruptedException异常",e);
        } catch (ExecutionException e) {
            log.info("首页加载ExecutionException异常",e);
        }

    }


}
