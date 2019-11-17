package com.kibug.blog.admin.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kibug.blog.common.entity.KbCustomer;
import com.kibug.blog.common.form.KbCustomerForm;
import com.kibugs.blog.api.KbBlogCustomerDubboService;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;
import com.kibugs.blog.request.CustomerIntoDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author : chenxingfei
 * @date: 2019-11-15  21:51
 * @description: 客户信息管理
 */
@Service
public class CustomerManagementService implements BaseManagementService<KbCustomer> {

    @Reference(version = "1.0.0")
    private KbBlogCustomerDubboService<KbCustomer> customerDubboService;

    private final StringRedisTemplate redisTemplate;

    public CustomerManagementService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 登录
     * @param login
     * @return
     */
    public CommonResponse<KbCustomerForm> login(KbCustomerForm login) {
        CustomerIntoDTO customerIntoDTO = CustomerIntoDTO.builder().username(login.getUsername()).password(login.getPassword()).build();
        CommonRequest<CustomerIntoDTO> commonRequest = CommonRequest.<CustomerIntoDTO>builder().data(customerIntoDTO).build();
        CommonResponse<KbCustomer> commonResponse = customerDubboService.signIn(commonRequest);
        if(commonResponse.getSuccess() && commonResponse.getData()!=null){
            BeanUtils.copyProperties(commonResponse.getData(),login);
            login.setToken(UUID.randomUUID().toString());
            redisTemplate.opsForValue().set(login.getToken(), JSON.toJSONString(login));
            return CommonResponse.success(login);
        }
        return CommonResponse.error();
    }

    public CommonResponse<KbCustomerForm> info(String token) {
        String userInfo = redisTemplate.opsForValue().get(token);
        if(StringUtils.isEmpty(userInfo)){
            return CommonResponse.error(CommonResponse.ResponseStatusEnum.TOKEN_INVALID);
        }
        return CommonResponse.success(JSON.parseObject(userInfo,KbCustomerForm.class));
    }

    @Override
    public CommonResponse createOrUpdate(KbCustomer kbTag) {
        boolean saveOrUpdate = customerDubboService.saveOrUpdate(kbTag);
        if (saveOrUpdate) {
            return CommonResponse.success();
        }
        return CommonResponse.error();
    }

    @Override
    public CommonResponse deleteById(Long id) {
        boolean saveOrUpdate = customerDubboService.removeById(id);
        if (saveOrUpdate) {
            return CommonResponse.success();
        }
        return CommonResponse.error();
    }

    @Override
    public CommonResponse<KbCustomer> getById(Long id) {
        KbCustomer kbTag = customerDubboService.getById(id);
        return CommonResponse.success(kbTag);
    }

    @Override
    public CommonResponse<IPage<KbCustomer>> page(Integer current, Integer pageSize) {
        Page<KbCustomer> kbTagPage = new Page<>(current, pageSize);
        IPage<KbCustomer> page = customerDubboService.page(kbTagPage);
        return CommonResponse.success(page);
    }
}
