package com.kibus.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 标签表
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Data

@Accessors(chain = true)
public class KbTag {

    private static final long serialVersionUID=1L;

    private String name;

    private String remark;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
