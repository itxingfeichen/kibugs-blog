package com.kibus.blog.provider;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibug.blog.common.dto.KbBlogPublishDTO;
import com.kibug.blog.common.entity.*;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;
import com.kibus.blog.service.*;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:03
 * @description: 博客dubbo服务实现类
 */
@Service(version = "1.0.0")
@AllArgsConstructor
public class KbBlogDubboServiceImpl implements KbBlogDubboService {

    private final IKbBlogService blogService;

    private final IKbCustomerService customerService;

    private final IKbCommentService commentService;

    private final IKbCategoryService categoryService;

    private final IKbBlogTagService blogTagService;

    private final IKbTagService tagService;


    @Override
    public CommonResponse<KbBlogDTO> getOne(Long id) {
        KbBlog kbBlog = blogService.getById(id);
        if (kbBlog == null) {
            return CommonResponse.<KbBlogDTO>builder().success(false).errMsg("未查到博客").build();
        }
        KbBlogDTO kbBlogDTO = new KbBlogDTO();
        BeanUtils.copyProperties(kbBlog, kbBlogDTO);
        // 构建用户信息和评论信息线程
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            KbCustomer customer = new KbCustomer();
            customer.setId(kbBlog.getCustomerId());
            KbCustomer kbCustomer = customerService.getOne(Wrappers.query());
            kbBlogDTO.setCustomer(kbCustomer);

        }).thenRun(() -> {
            List<KbComment> kbComments = commentService.lambdaQuery().eq(KbComment::getBlogId, kbBlog.getId()).list();
            if (CollectionUtils.isEmpty(kbComments)) {
                return;
            }
            Map<Long, List<KbComment>> comments = kbComments.stream().collect(Collectors.groupingBy(KbComment::getCustomerId));
            comments.forEach((customerId, kbComments1) -> {
                if (id == null) {
                    // todo
                }
            });


        });

        /**
         * 构建标签和分类信息线程
         */
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            kbBlogDTO.setCategory(categoryService.getById(kbBlog.getCategoryId()));
            // 查询标签信息
            List<KbBlogTag> blogTags = blogTagService.lambdaQuery().eq(KbBlogTag::getBlogId, kbBlogDTO.getId()).list();
            if (!CollectionUtils.isEmpty(blogTags)) {
                List<KbTag> tagList = tagService.lambdaQuery().in(KbTag::getId, blogTags.stream().map(KbBlogTag::getTagId).collect(Collectors.toSet())).list();
                kbBlogDTO.setTags(tagList);
            }

        });
        try {
            CompletableFuture.allOf(future, completableFuture).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询detail的数据
        KbBlogDetail blogDetail = new KbBlogDetail();
        blogDetail.setBlogId(id);
        KbBlogDetail detail = blogDetail.selectOne(Wrappers.lambdaQuery(blogDetail));
        if (detail != null) {
            kbBlogDTO.setContent(detail.getContent());
        }
        return CommonResponse.<KbBlogDTO>builder().success(true).data(kbBlogDTO).build();
    }

    @Override
    public CommonResponse<IPage<KbBlog>> indexPage(IPage<KbBlog> page, KbBlog blog, Set<Long> ids) {
        IPage<KbBlog> iPage;
        if (blog != null) {
            iPage =  blogService.page(page, Wrappers.lambdaQuery(blog).orderByAsc(KbBlog::getCategoryId).orderByDesc(KbBlog::getUpdateTime));
        }
        else if(!CollectionUtils.isEmpty(ids)){
            iPage =   blogService.page(page, Wrappers.<KbBlog>lambdaQuery().in(KbBlog::getId,ids).orderByDesc(KbBlog::getUpdateTime));
        }else{
            iPage =  blogService.page(page, Wrappers.<KbBlog>lambdaQuery().orderByDesc(KbBlog::getUpdateTime));
        }
        List<KbBlog> records = iPage.getRecords();
        if (CollectionUtils.isEmpty(records)) {
            return CommonResponse.<IPage<KbBlog>>builder().build();
        }
        // 封装用户信息以及分类信息
        records.forEach(kbBlog -> {
            KbCustomer customer = customerService.getOne(Wrappers.<KbCustomer>lambdaQuery().select(KbCustomer.class, info -> Objects.equals(info.getColumn(), "nickname") || Objects.equals(info.getColumn(), "avatar_url")).eq(KbCustomer::getId, kbBlog.getCustomerId()));
            kbBlog.setCustomer(customer);
            kbBlog.setCategory(categoryService.getById(kbBlog.getCategoryId()));
        });
        return CommonResponse.<IPage<KbBlog>>builder().data(iPage).build();
    }

    @Override
    public CommonResponse<List<KbBlog>> indexRecommend() {
        IPage<KbBlog> page = new Page<>(1, 10, false);
        IPage<KbBlog> iPage = blogService.lambdaQuery().select(KbBlog::getId, KbBlog::getTitle, KbBlog::getCustomerId).eq(KbBlog::getPublishStatus, 1).eq(KbBlog::getRecommend, 1).orderByDesc(KbBlog::getUpdateTime).page(page);
        List<KbBlog> records = iPage.getRecords();
        // 封装用户信息
        records.forEach(kbBlog -> {
            KbCustomer customer = customerService.getOne(Wrappers.<KbCustomer>lambdaQuery().select(KbCustomer.class, info -> Objects.equals(info.getColumn(), "nickname") || Objects.equals(info.getColumn(), "avatar_url")).eq(KbCustomer::getId, kbBlog.getCustomerId()));
            kbBlog.setCustomer(customer);
        });
        return CommonResponse.<List<KbBlog>>builder().data(records).build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResponse publishBlog(CommonRequest<KbBlogPublishDTO> commonRequest) {
        KbBlogPublishDTO publishDTO = commonRequest.getData();
        KbBlog blog = new KbBlog();
        BeanUtils.copyProperties(publishDTO, blog);
        blog.setPublishStatus(Integer.valueOf(publishDTO.getPublishStatus()));
        blog.setAppreciateStatus(Objects.equals(publishDTO.getAppreciateStatus(), "on") ? 1 : 0);
        blog.setCommentStatus(Objects.equals(publishDTO.getCommentStatus(), "on") ? 1 : 0);
        blog.setAppreciateStatus(Objects.equals(publishDTO.getAppreciateStatus(), "on") ? 1 : 0);

        blog.setCategoryId(Long.valueOf(publishDTO.getCategory()));
        if (!blog.insert()) {
            return CommonResponse.<List<KbBlog>>builder().success(false).errMsg("博客发布失败").build();
        }
        // 保存博客详情
        KbBlogDetail blogDetail = new KbBlogDetail();
        blogDetail.setBlogId(blog.getId());
        blogDetail.setContent(publishDTO.getContent());
        if (!blogDetail.insert()) {
            return CommonResponse.<List<KbBlog>>builder().success(false).errMsg("博客发布失败").build();
        }

        // 保存标签映射关系
        Stream.of(publishDTO.getTags().split(",")).forEach(tagId -> {
            KbBlogTag kbBlogTag = new KbBlogTag();
            kbBlogTag.setBlogId(blog.getId());
            kbBlogTag.setTagId(Long.valueOf(tagId));
            kbBlogTag.insert();
        });

        return CommonResponse.<List<KbBlog>>builder().success(true).build();
    }


}
