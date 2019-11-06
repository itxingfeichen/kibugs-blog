package com.kibug.blog.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author : chenxingfei
 * @date: 2019-11-06  07:54
 * @description: 博客详情
 */
@Data
@Accessors(chain = true)
@TableName("kb_blog")
public class KbBlogDetail extends Model<KbBlogDetail> {

    @TableId
    private Long id;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 博客内容
     */
    private String content;
}
