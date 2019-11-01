package com.kibus.blog.entity;

import java.time.LocalDateTime;
import com.baomidou.ant.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jannik
 * @since 2019-11-01
 */
@Data

@Accessors(chain = true)
public class KbCustomer {

    private static final long serialVersionUID=1L;

    /**
     * 手机号
     */
    private String cellPhone;

    /**
     * 实际名称
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户状态(0：正常，1：已禁用)
     */
    private Boolean userStatus;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
