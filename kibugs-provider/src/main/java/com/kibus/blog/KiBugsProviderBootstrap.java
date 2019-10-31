package com.kibus.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
@MapperScan(basePackages = "com.kibus.blog.mapper")
public class KiBugsProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(KiBugsProviderBootstrap.class)
                .run(args);
    }
}