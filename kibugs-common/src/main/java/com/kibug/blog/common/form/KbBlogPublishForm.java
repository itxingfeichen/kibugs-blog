package com.kibug.blog.common.form;

import lombok.Data;

/**
 * @author : chenxingfei
 * @date: 2019-11-06  07:10
 * @description: 博客发布表单对象
 */
@Data
public class KbBlogPublishForm {


    /**
     * 博客ID
     */
    private Long id;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客概述
     */
    private String description;

    /**
     * 博客内容
     */
    private String content;

    /**
     * 发布状态（1：已发布，0：待发布）
     */
    private String publishStatus;

    /**
     * 首图地址
     */
    private String firstImageUrl;

    /**
     * 博客类型（0：原创，1：转载，2：翻译）
     */
    private Integer blogType;

    /**
     * 赞赏按钮开关（0：关闭，1：开启）
     */
    private String appreciateStatus;

    /**
     * 分类ID
     */
    private String category;

    /**
     * 标签ID
     */
    private String tags;

    /**
     * 评论开关（0：关闭，1：开启）
     */
    private String commentStatus;

    /**
     * 转载声明（0：不需要，1：需要）
     */
    private String reprintStatus;
}
