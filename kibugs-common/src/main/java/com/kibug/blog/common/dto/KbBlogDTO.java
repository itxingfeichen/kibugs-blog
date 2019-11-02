package com.kibug.blog.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author jannik
 * @since 2019-10-31
 */
@Data
public class KbBlogDTO implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客内容
     */
    private String context;

    /**
     * 发布状态（1：已发布，0：待发布）
     */
    private Integer publishStatus;

    /**
     * 用户id
     */
    private Long customerId;

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
    private Integer appreciateStatus;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
