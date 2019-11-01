package com.kibus.blog;

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
public class KiBugsProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(KiBugsProviderBootstrap.class)
                .run(args);
    }
}