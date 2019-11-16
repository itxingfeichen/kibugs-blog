package com.kibug.blog.admin.controller;

import com.kibug.blog.admin.service.CustomerManagementService;
import com.kibug.blog.common.form.KbCustomerForm;
import com.kibugs.blog.common.CommonResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenxingfei
 * @date: 2019-11-15  21:38
 * @description: 博客管理
 */
@RestController
@RequestMapping(value = "/admin/server/user")
public class CustomerManagementController {

    private final CustomerManagementService managementService;

    public CustomerManagementController(CustomerManagementService managementService) {
        this.managementService = managementService;
    }


    @RequestMapping("login")
    public CommonResponse<KbCustomerForm> login(@RequestBody KbCustomerForm login) {
        return managementService.login(login);
    }


    @RequestMapping("info")
    public CommonResponse<KbCustomerForm> info(@RequestParam("token") String token) {
        return managementService.info(token);
    }


}
