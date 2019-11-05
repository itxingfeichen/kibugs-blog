package com.kibug.blog.common.enums;

/**
 * @author : chenxingfei
 * @date: 2019-11-05  22:34
 * @description: 博客类型
 */
public enum BlogType {

    /**
     * 原创，转载，翻译，其他
     */
    ORIGINAL("原创"),REPRINT("转载"),TRANSLATION("翻译"),OTHER("其他");

    private String info;

    BlogType(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }


}
