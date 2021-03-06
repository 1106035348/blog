package com.yl.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 读取配置文件
 * @author YL
 * @date 16:11 2019/12/13
 */
@Data
@Configuration
public class SystemConfig {

    @Value("${file.img.access}")
    private String access;
    @Value("${file.img.upload}")
    private String upload;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.database}")
    private Integer database;
    @Value("${spring.redis.timeout}")
    private int timeout;
}
