package com.kibugs.blog.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kibug.blog.common.entity.KbCategory;
import com.kibugs.blog.common.CommonRequest;
import com.kibugs.blog.common.CommonResponse;

import java.util.List;
import java.util.Map;

/**
 * @author : chenxingfei
 * @date: 2019-10-31  08:02
 * @description: 博客分类dubbo服务
 */
public interface KbBlogCategoryDubboService<T> extends IService<T> {

    /**
     * 获取top5分类（默认返回博客数量最多的5种分类）
     * @return
     */
    CommonResponse<List<Map<String,Integer>>> getCategoryTop5();

    /**
     * 分页获取分类数据
     * @param page 分页条件
     * @param category 查询条件实体
     * @return
     */
    CommonResponse<IPage<KbCategory>> list(IPage page,KbCategory category);

    /**
     * 保存分类
     * @param categoryCommonRequest
     * @return
     */
    CommonResponse createOrUpdate(CommonRequest<KbCategory> categoryCommonRequest);
}
