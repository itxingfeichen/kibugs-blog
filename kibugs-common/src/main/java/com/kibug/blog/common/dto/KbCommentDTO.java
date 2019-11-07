package com.kibug.blog.common.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.kibug.blog.common.entity.KbComment;
import com.kibug.blog.common.entity.KbCustomer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author : chenxingfei
 * @date: 2019-11-07  07:56
 * @description: 评论数据封装
 */
@Data
public class KbCommentDTO implements Serializable {

    private Long id;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 评论用户
     */
    private KbCustomer customer;


    /**
     * 是否可以点赞（1：可以，0：不可以）
     */
    private Boolean praiseStatus;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 删除标记
     */
    @TableLogic
    private Integer deleteStatus;


    /**
     * 创建时间(评论时间)
     */
    private Date createTime;

    /**
     * 评论列表
     */
    private List<KbComment> comments;
}
