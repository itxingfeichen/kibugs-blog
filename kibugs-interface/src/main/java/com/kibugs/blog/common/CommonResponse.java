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
public class CommonResponse<T> implements Serializable {

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

    /**
     * 响应状态信息定义
     */
    public enum ResponseStatusEnum{
        // 成功返回
        SUCCESS("20000",""),

        // 系统异常
        SYS_ERROR("E0000","系统错误"),

        // token违法
        TOKEN_INVALID("E0001","token不合法");

        private String code;

        private String errMsg;


        ResponseStatusEnum(String code, String errMsg) {
            this.code = code;
            this.errMsg = errMsg;
        }

        public String getCode() {
            return code;
        }

        public String getErrMsg() {
            return errMsg;
        }
    }


    /**
     * 成功返回，并携带数据
     * @param data 需要携带的数据
     * @return {@link CommonResponse}
     */
    public static CommonResponse success(Object data){
        return CommonResponse.builder().success(true).code(ResponseStatusEnum.SUCCESS.code).data(data).build();
    }

    /**
     * 成功返回，不携带数据
     * @return {@link CommonResponse}
     */
    public static CommonResponse success(){
        return CommonResponse.builder().success(true).code(ResponseStatusEnum.SUCCESS.code).build();
    }


    /**
     * 错误返回，不携带数据(系统异常)
     * @return {@link CommonResponse}
     */
    public static CommonResponse error(){
        return CommonResponse.builder().success(false).code(ResponseStatusEnum.SYS_ERROR.code).errMsg(ResponseStatusEnum.SYS_ERROR.errMsg).build();

    }

    /**
     * 错误返回，不携带数据(自定义异常)
     * @return {@link CommonResponse}
     */
    public static CommonResponse error(ResponseStatusEnum statusEnum){
        return CommonResponse.builder().success(false).code(statusEnum.code).errMsg(statusEnum.errMsg).build();

    }

    /**
     * 错误返回，携带数据
     * @return {@link CommonResponse}
     */
    public static CommonResponse error(ResponseStatusEnum statusEnum ,Object data){
        return CommonResponse.builder().success(false).code(statusEnum.code).errMsg(statusEnum.errMsg).data(data).build();

    }

}
