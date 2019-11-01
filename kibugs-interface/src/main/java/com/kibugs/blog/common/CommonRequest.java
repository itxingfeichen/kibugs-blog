package com.kibugs.blog.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : chenxingfei
 * @date: 2019-11-01  07:38
 * @description: 统一请求参数数据格式
 */
@Data
@Builder
public class CommonRequest<T extends Serializable> implements Serializable {

    /**
     * 错误码
     */
    private String requestId;

    /**
     * 成功状态
     */
    private Boolean traceId;


    /**
     * 请求参数数据
     */
    private T data;

}
