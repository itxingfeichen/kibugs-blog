package com.kibus.blog.provider;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kibug.blog.common.entity.KbCustomer;
import com.kibugs.blog.api.KbBlogCustomerDubboService;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;
import com.kibugs.blog.request.CustomerIntoDTO;
import com.kibus.blog.service.IKbCustomerService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author : chenxingfei
 * @date: 2019-11-04  21:27
 * @description: 客户dubbo服务
 */
@Service(version = "1.0.0")
public class KbBlogCustomerDubboServiceImpl implements KbBlogCustomerDubboService {

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
        kbCustomer.insert();
        return CommonResponse.builder().success(true).build();
    }

    @Override
    public CommonResponse<KbCustomer> signIn(CommonRequest<CustomerIntoDTO> commonRequest) {
        KbCustomer kbCustomer = new KbCustomer();
        CustomerIntoDTO customerIntoDTO = commonRequest.getData();
        LambdaQueryWrapper<KbCustomer> wrapper = Wrappers.<KbCustomer>lambdaQuery().and(lambdaQueryWrapper -> Wrappers.<KbCustomer>lambdaQuery().eq(KbCustomer::getEmail, customerIntoDTO.getEmail()).eq(KbCustomer::getPassword, customerIntoDTO.getPassword())).
                or(lambdaQueryWrapper -> Wrappers.<KbCustomer>lambdaQuery().eq(KbCustomer::getUsername, customerIntoDTO.getUsername()).eq(KbCustomer::getPassword, customerIntoDTO.getPassword()));
        KbCustomer customer = kbCustomer.selectOne(wrapper);
        if (customer == null) {
            return CommonResponse.<KbCustomer>builder().success(false).errMsg("登录账号或密码错误").build();
        }
        return CommonResponse.<KbCustomer>builder().data(customer).success(true).build();
    }
}
