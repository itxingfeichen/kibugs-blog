package com.kibugs.blog.web;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {MybatisPlusAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class KiBugsConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(KiBugsConsumerBootstrap.class);

    }

}
