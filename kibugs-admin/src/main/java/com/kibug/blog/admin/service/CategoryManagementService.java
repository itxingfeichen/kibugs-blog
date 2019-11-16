package com.kibug.blog.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kibug.blog.common.entity.KbCategory;
import com.kibugs.blog.api.KbBlogCategoryDubboService;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author : chenxingfei
 * @date: 2019-11-16  10:46
 * @description: 博客管理
 */
@Service
public class CategoryManagementService {

    @Reference(version = "1.0.0")
    private KbBlogCategoryDubboService categoryDubboService;


    /**
     * 分页查询
     * @param current
     * @param pageSize
     * @param name
     * @return
     */
    public CommonResponse<IPage<KbCategory>> list(Integer current, Integer pageSize, String name) {
        IPage page = new Page();
        page.setCurrent(current).setSize(pageSize);
        KbCategory category = new KbCategory();
        if (!StringUtils.isEmpty(name)) {
            category.setName(name);
        }
        return categoryDubboService.list(page, category);
    }

    /**
     * 添加分类
     * @param category
     * @return
     */
    public CommonResponse createOrUpdate(KbCategory category) {
        return categoryDubboService.createOrUpdate(CommonRequest.<KbCategory>builder().data(category).build());
    }
}
