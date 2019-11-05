package com.kibugs.blog.web.service;

import com.kibug.blog.common.entity.KbCustomer;
import com.kibugs.blog.api.KbBlogCustomerDubboService;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;
import com.kibugs.blog.request.CustomerIntoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author : chenxingfei
 * @date: 2019-11-04  21:26
 * @description: 客户服务
 */
@Service
@Slf4j
public class KbCustomerService {


    @Reference(version = "1.0.0")
    private KbBlogCustomerDubboService kbBlogDubboService;


    /**
     * 注册
     * @param customerIntoDTO
     * @return
     */
    public CommonResponse signUp(CustomerIntoDTO customerIntoDTO) {

        return kbBlogDubboService.signUp(CommonRequest.<CustomerIntoDTO>builder().data(customerIntoDTO).build());
    }


    /**
     * 登录
     * @param customerIntoDTO
     * @return
     */
    public CommonResponse<KbCustomer> signIn(CustomerIntoDTO customerIntoDTO){
        return kbBlogDubboService.signIn(CommonRequest.<CustomerIntoDTO>builder().data(customerIntoDTO).build());

    }

}
