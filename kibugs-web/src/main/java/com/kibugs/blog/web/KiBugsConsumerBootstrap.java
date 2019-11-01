package com.kibugs.blog.web;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/10/31  22:31
 * @description: 博客web服务
 **/
@SpringBootApplication(exclude = {MybatisPlusAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class KiBugsConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(KiBugsConsumerBootstrap.class);

    }

}
