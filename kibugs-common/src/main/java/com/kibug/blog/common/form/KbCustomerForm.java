package com.kibug.blog.common.form;

import lombok.Data;

/**
 * @author : chenxingfei
 * @date: 2019-11-15  21:47
 * @description: 客户相关参数构建
 */
@Data
public class KbCustomerForm {

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
     * token生成
     */
    private String token;

    /**
     * 头像地址
     */
    private String avatarUrl;
}
