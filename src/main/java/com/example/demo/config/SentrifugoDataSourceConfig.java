package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties("spring.datasource")
public class SentrifugoDataSourceConfig extends HikariConfig {

    @Bean
    public HikariDataSource getDataSource(){
        return new HikariDataSource(this);
    }
}
