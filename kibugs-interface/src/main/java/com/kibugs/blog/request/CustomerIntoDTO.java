package com.kibugs.blog.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : chenxingfei
 * @date: 2019-11-04  21:30
 * @description: 客户管理基础参数
 */
@Data
@Builder
public class CustomerIntoDTO implements Serializable {

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;


}
