package com.kibugs.blog.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibug.blog.common.entity.KbBlog;
import com.kibugs.blog.api.DemoService;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.common.CommonResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/10/31  22:31
 * @description: 博客业务处理类
 **/
@Service
public class KiBugsBlogService {

    @Reference(version = "1.0.0")
    private DemoService demoService;

    @Reference(version = "1.0.0")
    private KbBlogDubboService kbBlogDubboService;

    public KbBlogDTO getBlogById(Long id) {
        CommonResponse<KbBlogDTO> one = kbBlogDubboService.getOne(id);
        return one.getData();
    }

    /**
     * 分页获取首页数据
     * @param current
     * @param size
     * @return
     */
    public IPage<KbBlog> indexPage(long current,long size){
        IPage<KbBlog> page = new Page<>(current,size);
        CommonResponse<IPage<KbBlog>> commonResponse = kbBlogDubboService.indexPage(page);
        return commonResponse.getData();
    }

}
