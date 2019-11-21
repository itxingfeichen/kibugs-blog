package com.kibus.blog.provider;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kibug.blog.common.entity.KbBlogTag;
import com.kibugs.blog.api.KbBlogTagDubboService;
import com.kibugs.blog.common.CommonResponse;
import com.kibus.blog.mapper.KbBlogTagMapper;
import com.kibus.blog.service.IKbBlogTagService;
import com.kibus.blog.service.IKbTagService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:02
 * @description: 博客分类dubbo服务
 */
@Service(version = "1.0.0")
public class KbBlogTagDubboServiceImpl extends ServiceImpl<KbBlogTagMapper, KbBlogTag> implements KbBlogTagDubboService<KbBlogTag> {

    private final IKbTagService tagService;

    private final IKbBlogTagService blogTagService;

    public KbBlogTagDubboServiceImpl(IKbTagService tagService, IKbBlogTagService blogTagService) {
        this.tagService = tagService;
        this.blogTagService = blogTagService;
    }

    @Override
    public CommonResponse<List<Map<String, Integer>>> getTagsForTop10() {
        return CommonResponse.<List<Map<String, Integer>>>builder().data(tagService.getTagsForTop10()).build();
    }

    @Override
    public CommonResponse<List<Map<String, Object>>> getAllTags() {
        return CommonResponse.<List<Map<String, Object>>>builder().data(tagService.getAllTags()).build();
    }

    @Override
    public CommonResponse<IPage<KbBlogTag>> listPage(IPage page, Long tagId) {
        IPage<KbBlogTag> iPage = blogTagService.lambdaQuery().eq(KbBlogTag::getTagId, tagId).page(page);
        return CommonResponse.success(iPage);
    }
}
