package com.kibug.blog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Data
@TableName(value = "kb_comment")
@Accessors(chain = true)
public class KbComment extends Model<KbComment> implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Long id;

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
     * 删除标记
     */
    @TableLogic
    private Integer deleteStatus;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;


}
