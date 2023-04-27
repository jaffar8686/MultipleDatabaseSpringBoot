package com.example.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "secondaryEntityManager",transactionManagerRef = "secondaryTransactionManager",basePackages = {"com.example.demo.secondary"})
public class SecondayDatabaseConfig {



    @Bean(name = "secondaryDatasource")
    @ConfigurationProperties(prefix = "spring.seconddatasource")
    public DataSource getSecondaryDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryEntityManager")
    public LocalContainerEntityManagerFactoryBean getSecondaryEntityManager(EntityManagerFactoryBuilder builder,@Qualifier("secondaryDatasource") DataSource dataSource){
        return  builder.dataSource(dataSource).packages("com.example.demo.secondary").build();

    }

    @Bean(name ="secondaryTransactionManager")
    public PlatformTransactionManager getSecondaryTransactionManager(@Qualifier("secondaryEntityManager") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
