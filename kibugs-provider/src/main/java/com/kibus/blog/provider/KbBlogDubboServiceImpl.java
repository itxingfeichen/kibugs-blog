package com.kibus.blog.provider;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kibug.blog.common.dto.KbBlogDTO;
import com.kibug.blog.common.entity.KbBlog;
import com.kibugs.blog.api.KbBlogDubboService;
import com.kibugs.blog.common.CommonResponse;
import com.kibus.blog.service.IKbBlogService;
import com.kibus.blog.service.IKbCustomerService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:03
 * @description: 博客dubbo服务实现类
 */
@Service(version = "1.0.0")
public class KbBlogDubboServiceImpl implements KbBlogDubboService {

    @Autowired
    private IKbBlogService blogService;

    @Autowired
    private IKbCustomerService customerService;

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
        IPage<KbBlog> iPage = blogService.page(page);
        List<KbBlog> records = iPage.getRecords();
        if (CollectionUtils.isEmpty(records)) {
            return CommonResponse.<IPage<KbBlog>>builder().build();
        }
        // 封装用户信息
        records.forEach(kbBlog -> kbBlog.setKbCustomer(customerService.getById(kbBlog.getCustomerId())));
        return CommonResponse.<IPage<KbBlog>>builder().data(iPage).build();
    }


}
