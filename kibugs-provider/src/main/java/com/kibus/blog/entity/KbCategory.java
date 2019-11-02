package com.kibus.blog.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Data

@Accessors(chain = true)
public class KbCategory {

    private static final long serialVersionUID=1L;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
