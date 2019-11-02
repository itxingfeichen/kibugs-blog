package com.kibug.blog.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 点赞表
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Data

@Accessors(chain = true)
public class KbPraise implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    private Long id;

    /**
     * 被评论项目id（根据type区分，type为COMMENT则为评论id，type为BLOG则为博客id）
     */
    private Long projectId;

    /**
     * 点赞类型
     */
    private String type;

    /**
     * 点赞用户id
     */
    private Long customerId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
