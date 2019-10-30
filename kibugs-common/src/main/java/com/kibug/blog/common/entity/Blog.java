package com.kibug.blog.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : chenxingfei
 * @date: 2019-10-30  22:07
 * @description: 博客
 */
@Data
@TableName("ki_blog")
public class Blog {

    @TableId
    private Long id;


}
