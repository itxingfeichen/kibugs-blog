package com.kibug.blog.admin.controller;


import com.kibug.blog.admin.service.BaseManagementService;
import com.kibug.blog.admin.service.TagManagementService;
import com.kibug.blog.common.entity.KbTag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author : chenxingfei
 * @date: 2019-11-17  00:28
 * @description: 标签管理控制器
 */

@RestController
@RequestMapping(value = "admin/server/tag")
public class TagManagementController extends BaseManagementController<KbTag> {

    private final TagManagementService tagManagementService;

    public TagManagementController(TagManagementService tagManagementService) {
        this.tagManagementService = tagManagementService;
    }

    @Override
    protected BaseManagementService<KbTag> getService() {
        return tagManagementService;
    }
}
