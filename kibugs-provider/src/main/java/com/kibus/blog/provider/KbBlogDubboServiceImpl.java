package com.kibus.blog.provider;

import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.response.CommonResponse;
import com.kibus.blog.entity.KbBlog;
import com.kibus.blog.service.IKbBlogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static com.kibus.blog.utils.ResponseUtil.success;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:03
 * @description: 博客dubbo服务实现类
 */
@Service(version = "1.0.0")
public class KbBlogDubboServiceImpl implements KbBlogDubboService {

    @Autowired
    private IKbBlogService blogService;

    @Override
    public CommonResponse<KbBlogDTO> getOne(Long id) {
        KbBlog kbBlog = blogService.getById(id);
        if (kbBlog != null) {
            KbBlogDTO kbBlogDTO = new KbBlogDTO();
            BeanUtils.copyProperties(kbBlog, kbBlogDTO);
            return CommonResponse.<KbBlogDTO>builder().success(true).data(kbBlogDTO).build();
        }
        return CommonResponse.<KbBlogDTO>builder().success(true).build();
    }
}