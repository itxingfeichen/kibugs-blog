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
import com.kibus.blog.service.IKbBlogService;
import com.kibus.blog.service.IKbCategoryService;
import com.kibus.blog.service.IKbCommentService;
import com.kibus.blog.service.IKbCustomerService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    private final IKbCategoryService iKbCategoryService;


    @Override
    public CommonResponse<KbBlogDTO> getOne(Long id) {
        KbBlog kbBlog = blogService.getById(id);
        if (kbBlog == null) {
            return CommonResponse.<KbBlogDTO>builder().success(false).errMsg("未查到博客").build();
        }
        KbBlogDTO kbBlogDTO = new KbBlogDTO();
        BeanUtils.copyProperties(kbBlog, kbBlogDTO);
        // 构建用户信息和评论信息线程
        CompletableFuture.runAsync(() -> {
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
                if(id  == null){
                    // todo
                }
            });


        });

        /**
         * 构建标签和分类信息线程
         */
        CompletableFuture.runAsync(() -> {


        });


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
    public CommonResponse<IPage<KbBlog>> indexPage(IPage<KbBlog> page) {
        IPage<KbBlog> iPage = blogService.lambdaQuery().eq(KbBlog::getPublishStatus, 1).orderByDesc(KbBlog::getUpdateTime).page(page);
        List<KbBlog> records = iPage.getRecords();
        if (CollectionUtils.isEmpty(records)) {
            return CommonResponse.<IPage<KbBlog>>builder().build();
        }
        // 封装用户信息以及分类信息
        records.forEach(kbBlog -> {
            KbCustomer customer = customerService.getOne(Wrappers.<KbCustomer>lambdaQuery().select(KbCustomer.class, info -> Objects.equals(info.getColumn(), "nickname") || Objects.equals(info.getColumn(), "avatar_url")).eq(KbCustomer::getId, kbBlog.getCustomerId()));
            kbBlog.setCustomer(customer);
            kbBlog.setCategory(iKbCategoryService.getById(kbBlog.getCategoryId()));
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
