package com.kibug.blog.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kibug.blog.common.entity.KbBlog;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.common.CommonResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author : chenxingfei
 * @date: 2019-11-16  10:46
 * @description: 博客管理
 */
@Service
public class BlogManagementService {

    @Reference(version = "1.0.0")
    private KbBlogDubboService kbBlogDubboService;


    public CommonResponse list(Integer current, Integer pageSize) {
        IPage<KbBlog> page = new Page<>();
        page.setCurrent(current).setSize(pageSize);

        CommonResponse<IPage<KbBlog>> response = kbBlogDubboService.indexPage(page,null,null);
        return CommonResponse.success(response.getData());
    }
}
