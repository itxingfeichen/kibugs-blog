package com.kibug.blog.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kibug.blog.admin.service.CategoryManagementService;
import com.kibug.blog.common.entity.KbCategory;
import com.kibugs.blog.common.CommonResponse;
import org.springframework.web.bind.annotation.*;

/**
 * @author : chenxingfei
 * @date: 2019-11-15  21:38
 * @description: 分类管理
 */
@RestController
@RequestMapping(value = "admin/server/categories")
public class CategoryManagementController {

    private final CategoryManagementService categoryManagementService;

    public CategoryManagementController(CategoryManagementService categoryManagementService) {
        this.categoryManagementService = categoryManagementService;
    }

    /**
     * 获取博客详情
     *
     * @param id
     * @return
     */
    @RequestMapping("getBlogById/{id}")
    public CommonResponse blog(@PathVariable String id) {

        return null;

    }

    /**
     * 分页查询
     *
     * @param name
     * @param current
     * @param pageSize
     * @return
     */
    @RequestMapping("list")
    public CommonResponse<IPage<KbCategory>> list(@RequestParam(value = "name", defaultValue = "") String name,
                                                  @RequestParam(value = "current", defaultValue = "1") Integer current,
                                                  @RequestParam(value = "pageSize", defaultValue = "100") Integer pageSize) {
        return categoryManagementService.list(current, pageSize, name);

    }

    /***
     * 添加分类
     * @param category
     * @return
     */
    @RequestMapping("createOrUpdate")
    public CommonResponse createOrUpdate(@RequestBody KbCategory category) {
       return categoryManagementService.createOrUpdate(category);
    }

}
