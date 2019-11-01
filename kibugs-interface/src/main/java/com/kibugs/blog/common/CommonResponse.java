package com.kibugs.blog.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : chenxingfei
 * @date: 2019-11-01  07:38
 * @description: 统一响应格式
 */
@Data
@Builder
public class CommonResponse<T extends Serializable> implements Serializable {

    /**
     * 错误码
     */
    private String code;

    /**
     * 成功状态
     */
    private Boolean success;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 数据接口
     */
    private T data;

}
