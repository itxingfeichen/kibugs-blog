package com.kibugs.blog.api;

import com.kibug.blog.common.dto.KbBlogDTO;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:02
 * @description: 博客dubbo服务
 */
public interface KbBlogDubboService {

    KbBlogDTO getOne(Long id);
}
