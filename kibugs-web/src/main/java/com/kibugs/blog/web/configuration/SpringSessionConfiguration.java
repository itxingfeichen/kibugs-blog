package com.kibugs.blog.web.configuration;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author : chenxingfei
 * @date: 2019-11-03  22:44
 * @description: spring-session-data
 */
@EnableRedisHttpSession(redisNamespace = "kibugs:session")
public class SpringSessionConfiguration {


}