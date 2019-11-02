package com.kibus.blog.entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Data

@Accessors(chain = true)
public class KbComment {

    private static final long serialVersionUID=1L;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 评论用户id
     */
    private Long customerId;

    /**
     * 被评论用户id，-1代表主动评论
     */
    private Long beCommentedCustomerId;

    /**
     * 被评论id，默认为-1代表顶层评论
     */
    private Long parentCommentId;

    /**
     * 是否可以点赞（1：可以，0：不可以）
     */
    private Boolean praiseStatus;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
