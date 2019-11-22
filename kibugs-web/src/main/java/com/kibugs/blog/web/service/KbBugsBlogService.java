package com.kibugs.blog.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibug.blog.common.dto.KbBlogPublishDTO;
import com.kibug.blog.common.entity.*;
import com.kibug.blog.common.enums.PageType;
import com.kibug.blog.common.form.KbBlogPublishForm;
import com.kibugs.blog.api.KbBlogCategoryDubboService;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.api.KbBlogTagDubboService;
import com.kibugs.blog.api.KbTagDubboService;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

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

    @Reference(version = "1.0.0")
    private KbTagDubboService<KbTag> tagDubboService;

    @Reference(version = "1.0.0")
    private KbBlogTagDubboService<KbBlogTag> blogTagDubboService;

    @Reference(version = "1.0.0")
    private KbBlogCategoryDubboService<KbCategory> blogCategoryDubboService;

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
            IPage<KbBlog> blogLimit30 = listBlogLimit30(null,1);
            modelAndView.addObject("page", blogLimit30);
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
            CompletableFuture.allOf(blogAndCategoryTop5Future, tagTop10AndRecommendFuture).get();
        } catch (InterruptedException e) {
            log.info("首页加载InterruptedException异常", e);
        } catch (ExecutionException e) {
            log.info("首页加载ExecutionException异常", e);
        }

    }


    /**
     * 分类首页
     *
     * @param modelAndView
     */
    public void indexPageForCategory(ModelAndView modelAndView, Long categoryId) {

        // 获取所有分类
        CommonResponse<List<Map<String, Object>>> allCategory = blogCategoryDubboService.getAllCategory();
        List<Map<String, Object>> data = allCategory.getData();
        modelAndView.addObject("categories", data);
        if (categoryId == null) {
            categoryId = Long.valueOf(data.get(0).get("id") + "");
        }
        KbBlog blog = new KbBlog();
        blog.setCategoryId(categoryId);
        IPage<KbBlog> kbBlogIPage = listBlogLimit30(blog,1);
        modelAndView.addObject("currenIndex", categoryId);
        modelAndView.addObject("page", kbBlogIPage);

    }

    /**
     * 标签首页
     *
     * @param modelAndView
     * @param tagId
     */
    public void indexPageForTag(ModelAndView modelAndView, Long tagId) {
        CommonResponse<List<Map<String, Object>>> commonResponse = blogTagDubboService.getAllTags();
        List<Map<String, Object>> responseData = commonResponse.getData();
        IPage<KbBlogTag> page = new Page<>(1, 30);
        if (tagId == null) {
            tagId = (Long) responseData.get(0).get("id");
        }

        IPage<KbBlogTag> iPage = blogTagDubboService.listPage(page, tagId).getData();
        if (iPage != null) {
            Set<Long> collect = iPage.getRecords().stream().map(KbBlogTag::getBlogId).collect(Collectors.toSet());
            IPage<KbBlog> blogPage = new Page<>(1, 30);
            CommonResponse<IPage<KbBlog>> response = kbBlogDubboService.indexPage(blogPage, null, collect);
            modelAndView.addObject("page", response.getData());
        }
        modelAndView.addObject("currenIndex", tagId);
        modelAndView.addObject("tags", responseData);


    }

    /**
     * 获取前30博客
     */
    public IPage<KbBlog> listBlogLimit30(KbBlog blog,Integer current) {
        IPage<KbBlog> page = new Page<>(current, 30);
        CommonResponse<IPage<KbBlog>> commonResponse = kbBlogDubboService.indexPage(page, blog, null);
        return commonResponse.getData();
    }


    /**
     * 发布
     *
     * @param blog
     * @param currentCustomer
     * @return
     */
    public CommonResponse publishBlog(KbBlogPublishForm blog, KbCustomer currentCustomer) {
        KbBlogPublishDTO kbBlogPublishDTO = new KbBlogPublishDTO();
        BeanUtils.copyProperties(blog, kbBlogPublishDTO);
        kbBlogPublishDTO.setCustomerId(currentCustomer.getId());
        CommonRequest<KbBlogPublishDTO> commonRequest = CommonRequest.<KbBlogPublishDTO>builder().data(kbBlogPublishDTO).build();
        return kbBlogDubboService.publishBlog(commonRequest);
    }

    /**
     * 加载更多
     *
     * @param type     类型（1：首页；2：分类首页；3：标签首页）
     * @param current
     * @param objectId
     * @return
     */
    public CommonResponse<IPage<KbBlog>> loadMore(PageType type, Integer current, Long objectId) {
        switch (type) {
            case INDEX:
                return CommonResponse.success(listBlogLimit30(null, current));
            case CATEGORY_PAGE:
                final KbBlog kbBlog = new KbBlog();
                kbBlog.setCategoryId(objectId);
                return CommonResponse.success(listBlogLimit30(kbBlog, current));
            case TAG_PAGE:
                IPage<KbBlogTag> iPage = new Page<>(current,30,false);
                iPage = blogTagDubboService.listPage(iPage, objectId).getData();
                if (iPage != null) {
                    Set<Long> collect = iPage.getRecords().stream().map(KbBlogTag::getBlogId).collect(Collectors.toSet());
                    IPage<KbBlog> blogPage = new Page<>(1, 30);
                    return kbBlogDubboService.indexPage(blogPage, null, collect);
                }
            default:
                break;
        }
        return CommonResponse.success();

    }


}
