package com.kibug.blog.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
public class KbTag implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    private Long id;

    private String name;

    private String remark;

    /**
     * 更新时间
     */
    private Date updateTime;


}
