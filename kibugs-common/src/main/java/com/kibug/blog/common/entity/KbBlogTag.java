package com.kibug.blog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 博客分类映射表
 * </p>
 *
 * @author jannik
 * @since 2019-11-06
 */
@Data
@Accessors(chain = true)
@TableName("kb_blog_tag")
public class KbBlogTag extends Model<KbBlogTag> {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 标签id
     */
    private Long tagId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;


}
