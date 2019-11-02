package com.kibus.blog.service.impl;

import com.kibug.blog.common.entity.KbCustomer;
import com.kibus.blog.mapper.KbCustomerMapper;
import com.kibus.blog.service.IKbCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Service
public class KbCustomerServiceImpl extends ServiceImpl<KbCustomerMapper, KbCustomer> implements IKbCustomerService {

}
