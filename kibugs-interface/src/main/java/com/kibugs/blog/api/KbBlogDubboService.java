package com.kibugs.blog.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibug.blog.common.dto.KbBlogPublishDTO;
import com.kibug.blog.common.entity.KbBlog;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;

import java.util.List;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:02
 * @description: 博客dubbo服务
 */
public interface KbBlogDubboService {

    /**
     * 根据id获取博客数据
     * @param id
     * @return
     */
    CommonResponse<KbBlogDTO> getOne(Long id);


    /**
     * 获取首页分页数据
     * @param page
     * @return
     */
    CommonResponse<IPage<KbBlog>> indexPage(IPage<KbBlog> page);

    /**
     * 获取首页推荐数据
     * @return
     */
    CommonResponse<List<KbBlog>> indexRecommend();


    /**
     * 博客发布
     * @param commonRequest
     * @return
     */
    CommonResponse publishBlog(CommonRequest<KbBlogPublishDTO> commonRequest);

}
