package com.kibug.blog.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kibug.blog.common.entity.KbTag;
import com.kibugs.blog.api.KbTagDubboService;
import com.kibugs.blog.common.CommonResponse;
import org.apache.dubbo.config.annotation.Reference;

/**
 * @author : chenxingfei
 * @date: 2019-11-16  23:15
 * @description: 标签服务
 */
public class TagManagementService implements BaseManagementService<KbTag> {

    @Reference(version = "1.0.0")
    private KbTagDubboService<KbTag> tagDubboService;

    @Override
    public CommonResponse createOrUpdate(KbTag kbTag) {
        boolean saveOrUpdate = tagDubboService.saveOrUpdate(kbTag);
        if (saveOrUpdate) {
            return CommonResponse.success();
        }
        return CommonResponse.error();
    }

    @Override
    public CommonResponse deleteById(Long id) {
        boolean saveOrUpdate = tagDubboService.removeById(id);
        if (saveOrUpdate) {
            return CommonResponse.success();
        }
        return CommonResponse.error();
    }

    @Override
    public CommonResponse<KbTag> getById(Long id) {
        KbTag kbTag = tagDubboService.getById(id);
        return CommonResponse.success(kbTag);
    }

    @Override
    public CommonResponse<IPage<KbTag>> page(Integer current, Integer pageSize) {
        Page<KbTag> kbTagPage = new Page<>(current, pageSize);
        IPage<KbTag> page = tagDubboService.page(kbTagPage);
        return CommonResponse.success(page);
    }
}
