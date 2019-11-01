package com.kibugs.blog.api;

import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibugs.blog.response.CommonResponse;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:02
 * @description: 博客dubbo服务
 */
public interface KbBlogDubboService {

    CommonResponse<KbBlogDTO> getOne(Long id);
}
