package com.kibug.blog.admin.controller;

import com.kibug.blog.admin.service.BlogManagementService;
import com.kibugs.blog.common.CommonResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenxingfei
 * @date: 2019-11-15  21:38
 * @description: 博客管理
 */
@RestController
@RequestMapping(value = "admin/server/blog")
public class BlogManagementController {

    private final BlogManagementService managementService;

    public BlogManagementController(BlogManagementService managementService) {
        this.managementService = managementService;
    }

    /**
     * 获取博客详情
     * @param id
     * @return
     */
    @RequestMapping("getBlogById/{id}")
    public CommonResponse blog(@PathVariable String id){

        return null;

    }


    @RequestMapping("list")
    public CommonResponse list(@RequestParam(value = "current",defaultValue = "1") Integer current,@RequestParam(value = "pageSize",defaultValue = "100") Integer pageSize){

        return managementService.list(current,pageSize);

    }
}
