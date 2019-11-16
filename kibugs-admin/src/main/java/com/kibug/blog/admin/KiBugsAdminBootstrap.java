package com.kibug.blog.admin;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;


/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2019/11/13  22:31
 * @description: 博客admin服务
 **/
@SpringBootApplication(exclude = {MybatisPlusAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableCaching
public class KiBugsAdminBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(KiBugsAdminBootstrap.class);

    }

}
