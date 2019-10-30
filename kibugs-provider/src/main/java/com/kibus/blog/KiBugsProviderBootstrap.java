package com.kibus.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;


@EnableAutoConfiguration
@MapperScan(basePackages = "com.dubbo.example.mapper")
public class KiBugsProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(KiBugsProviderBootstrap.class)
                .run(args);
    }
}