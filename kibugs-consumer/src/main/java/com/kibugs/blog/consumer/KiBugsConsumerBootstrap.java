package com.kibugs.blog.consumer;

import com.kibugs.blog.api.DemoService;
import com.kibugs.blog.api.KbBlogDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class KiBugsConsumerBootstrap {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Reference(version = "1.0.0")
    private DemoService demoService;
    @Reference(version = "1.0.0")
    private KbBlogDubboService kbBlogDubboService;


    public static void main(String[] args) {
        SpringApplication.run(KiBugsConsumerBootstrap.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        System.out.println("iKbBlogService.getById(1) = " + kbBlogDubboService.getOne(1L));
        return args -> logger.info(demoService.sayHello("Provider"));
//        return null;
    }
}
