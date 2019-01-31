package com.goodrain.springbootdemo.config;

import com.goodrain.springbootdemo.service.DBInfoService;
import com.goodrain.springbootdemo.util.DBConnPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public DBConnPool dbConnPool() {
        return DBConnPool.getInstance();
    }
}
