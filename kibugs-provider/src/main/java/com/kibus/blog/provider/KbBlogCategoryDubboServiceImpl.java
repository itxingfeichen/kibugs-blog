package com.kibus.blog.provider;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kibug.blog.common.entity.KbCategory;
import com.kibugs.blog.api.KbBlogCategoryDubboService;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;
import com.kibus.blog.mapper.KbCategoryMapper;
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
public class KbBlogCategoryDubboServiceImpl   extends ServiceImpl<KbCategoryMapper, KbCategory> implements KbBlogCategoryDubboService<KbCategory> {

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


    @Override
    public CommonResponse<IPage<KbCategory>> list(IPage page, KbCategory category) {
        IPage iPage = categoryService.page(page, Wrappers.lambdaQuery(category));
        return CommonResponse.success(iPage);
    }

    @Override
    public CommonResponse createOrUpdate(CommonRequest<KbCategory> categoryCommonRequest) {

        KbCategory entity = categoryCommonRequest.getData();
        boolean orUpdate = categoryService.saveOrUpdate(entity);
        if (orUpdate) {
            return CommonResponse.success();
        } else {
            return CommonResponse.error();
        }
    }
}
