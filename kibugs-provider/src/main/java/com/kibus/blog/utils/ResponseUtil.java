package com.kibus.blog.utils;

import com.kibugs.blog.response.CommonResponse;

/**
 * @author : chenxingfei
 * @date: 2019-11-01  07:43
 * @description: 统一响应结果封装工具类 {@link CommonResponse}
 */
public class ResponseUtil<T> {

    /**
     * 失败结果封装
     * @param code
     * @param errMsg
     * @return
     */
    public static CommonResponse error(String code,String errMsg){
        return CommonResponse.builder().success(false).code(code).errMsg(errMsg).build();
    }

    /**
     * 成功并且不需要返回数据
     * @return
     */
    public static CommonResponse success(){
        return CommonResponse.builder().success(true).build();
    }



}
