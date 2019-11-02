package com.kibug.blog.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 博客分类映射表
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Data
@Accessors(chain = true)
@TableName("kb_blog_category")
public class KbBlogCategory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    private Long id;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;


}
