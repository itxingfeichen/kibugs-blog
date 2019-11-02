package com.kibus.blog.provider;

import com.kibugs.blog.api.KbBlogCategoryDubboService;
import com.kibugs.blog.common.CommonResponse;
import com.kibus.blog.service.IKbBlogService;
import com.kibus.blog.service.IKbCategoryService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:02
 * @description: 博客分类dubbo服务
 */
@Service(version = "1.0.0")
public class KbBlogCategoryDubboServiceImpl implements KbBlogCategoryDubboService {

    private final IKbBlogService blogService;

    private final IKbCategoryService categoryService;

    public KbBlogCategoryDubboServiceImpl(IKbBlogService blogService, IKbCategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @Override
    public CommonResponse<List<Map<String, Integer>>> getCategoryTop5() {
        List<Map<String, Integer>> categoryTop5 = categoryService.getCategoryTop5();
        return CommonResponse.<List<Map<String, Integer>>>builder().data(categoryTop5).build();
    }
}
