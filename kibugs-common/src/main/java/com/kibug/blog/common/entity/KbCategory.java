package com.kibug.blog.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
public class KbCategory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId
    private Long id;

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
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;


}
