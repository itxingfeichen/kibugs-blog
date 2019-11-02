package com.kibug.blog.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 博客
 * </p>
 *
 * @author jannik
 * @since 2019-10-31
 */
@Data
@Accessors(chain = true)
@TableName("kb_blog")
public class KbBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
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

    @TableLogic
    private Integer deleteStatus;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 发布用户信息
     */
    @TableField(exist = false)
    private KbCustomer kbCustomer;


}
