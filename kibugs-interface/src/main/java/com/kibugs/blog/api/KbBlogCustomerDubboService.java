package com.kibugs.blog.api;

import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;
import com.kibugs.blog.request.CustomerIntoDTO;

/**
 * @author : chenxingfei
 * @date: 2019-11-04  21:27
 * @description: 客户dubbo服务
 */
public interface KbBlogCustomerDubboService {

    /**
     * 注册
     * @param commonRequest
     * @return
     */
    CommonResponse signUp(CommonRequest<CustomerIntoDTO> commonRequest);


    /**
     * 登录
     * @param commonRequest
     * @return
     */
    CommonResponse signIn(CommonRequest<CustomerIntoDTO> commonRequest);

}
