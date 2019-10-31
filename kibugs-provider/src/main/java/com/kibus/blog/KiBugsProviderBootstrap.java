package com.kibus.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <p>
 *  dubbo服务提供启动类
 * </p>
 *
 * @author jannik
 * @since 2019-10-31
 */
@SpringBootApplication
@MapperScan(basePackages = "com.kibus.blog.mapper")
public class KiBugsProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(KiBugsProviderBootstrap.class)
                .run(args);
    }
}