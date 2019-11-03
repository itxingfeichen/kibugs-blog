package com.kibus.blog.provider;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibug.blog.common.entity.KbBlog;
import com.kibug.blog.common.entity.KbCustomer;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.common.CommonResponse;
import com.kibus.blog.service.IKbBlogService;
import com.kibus.blog.service.IKbCategoryService;
import com.kibus.blog.service.IKbCustomerService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:03
 * @description: 博客dubbo服务实现类
 */
@Service(version = "1.0.0")
public class KbBlogDubboServiceImpl implements KbBlogDubboService {

    private final IKbBlogService blogService;

    private final IKbCustomerService customerService;

    private final IKbCategoryService iKbCategoryService;

    public KbBlogDubboServiceImpl(IKbBlogService blogService, IKbCustomerService customerService, IKbCategoryService iKbCategoryService) {
        this.blogService = blogService;
        this.customerService = customerService;
        this.iKbCategoryService = iKbCategoryService;
    }

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
        IPage<KbBlog> iPage = blogService.lambdaQuery().select(KbBlog::getId, KbBlog::getTitle,KbBlog::getCustomerId).eq(KbBlog::getPublishStatus, 1).eq(KbBlog::getRecommend, 1).orderByDesc(KbBlog::getUpdateTime).page(page);
        List<KbBlog> records = iPage.getRecords();
        // 封装用户信息
        records.forEach(kbBlog -> {
            KbCustomer customer = customerService.getOne(Wrappers.<KbCustomer>lambdaQuery().select(KbCustomer.class, info -> Objects.equals(info.getColumn(), "nickname") || Objects.equals(info.getColumn(), "avatar_url")).eq(KbCustomer::getId, kbBlog.getCustomerId()));
            kbBlog.setCustomer(customer);
        });
        return CommonResponse.<List<KbBlog>>builder().data(records).build();
    }


}
