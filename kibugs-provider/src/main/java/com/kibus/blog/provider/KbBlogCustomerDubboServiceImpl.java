package com.kibus.blog.provider;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kibug.blog.common.entity.KbCustomer;
import com.kibugs.blog.api.KbBlogCustomerDubboService;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;
import com.kibugs.blog.request.CustomerIntoDTO;
import com.kibus.blog.mapper.KbCustomerMapper;
import com.kibus.blog.service.IKbCustomerService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author : chenxingfei
 * @date: 2019-11-04  21:27
 * @description: 客户dubbo服务
 */
@Service(version = "1.0.0")
public class KbBlogCustomerDubboServiceImpl extends ServiceImpl<KbCustomerMapper, KbCustomer> implements KbBlogCustomerDubboService<KbCustomer> {

    private final IKbCustomerService customerService;

    public KbBlogCustomerDubboServiceImpl(IKbCustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public CommonResponse signUp(CommonRequest<CustomerIntoDTO> commonRequest) {
        CustomerIntoDTO customerIntoDTO = commonRequest.getData();
        KbCustomer kbCustomer = new KbCustomer();
        kbCustomer.setAvatarUrl("https://picsum.photos/id/102/100/100");
        kbCustomer.setCellPhone(customerIntoDTO.getPhone());
        kbCustomer.setUsername(customerIntoDTO.getEmail());
        kbCustomer.setNickname(customerIntoDTO.getPhone());
        kbCustomer.setPassword(customerIntoDTO.getPassword());
        kbCustomer.setUserStatus(true);
        return CommonResponse.builder().success(kbCustomer.insert()).build();
    }

    @Override
    public CommonResponse<KbCustomer> signIn(CommonRequest<CustomerIntoDTO> commonRequest) {
        CustomerIntoDTO customerIntoDTO = commonRequest.getData();
        String email = customerIntoDTO.getEmail();
        String username = customerIntoDTO.getUsername();
        String password = customerIntoDTO.getPassword();
        if (StringUtils.isBlank(password)) {
            return CommonResponse.<KbCustomer>builder().success(false).errMsg("登录密码错误").build();
        }
        if (StringUtils.isBlank(email) && StringUtils.isBlank(username)) {
            return CommonResponse.<KbCustomer>builder().success(false).errMsg("登录账户错误").build();
        }
        KbCustomer customer = null;

        // 优先邮箱登录
        if (StringUtils.isNotBlank(email)) {
            customer = customerService.getOne(Wrappers.<KbCustomer>lambdaQuery().eq(KbCustomer::getEmail, email).eq(KbCustomer::getPassword, password));
        } else if (StringUtils.isNotBlank(username)) {
            customer = customerService.getOne(Wrappers.<KbCustomer>lambdaQuery().eq(KbCustomer::getUsername, username).eq(KbCustomer::getPassword, password));
        }
        if (customer == null) {
            return CommonResponse.<KbCustomer>builder().success(false).errMsg("登录账号或密码错误").build();
        }
        return CommonResponse.success(customer);
    }
}
