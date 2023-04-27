package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
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
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.example.demo.primary"} ,entityManagerFactoryRef = "primaryEntityManager" ,transactionManagerRef = "primaryTransactionManager")
public class PrimaryDatabaseConfig {

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getPrimaryDataSource(){
        DataSource dataSource = DataSourceBuilder.create().build();
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "primaryEntityManager")
    public LocalContainerEntityManagerFactoryBean primaryEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("primaryDataSource") DataSource primaryDatasource){

        return builder.dataSource(primaryDatasource)

                .packages("com.example.demo.primary")
                .persistenceUnit("sqlserver")
                .build();

    }

    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(@Qualifier("primaryEntityManager")EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }


}

