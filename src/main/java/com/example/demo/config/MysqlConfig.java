package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.example.demo.mysql"},entityManagerFactoryRef = "mysqlEntityManager",transactionManagerRef = "mysqlTransactionManager")
public class MysqlConfig {


    @Bean(name = "mysqlDatasource")
    @ConfigurationProperties("spring.thirddatasource")
    public DataSource getMysqlDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlEntityManager")
    public LocalContainerEntityManagerFactoryBean getMysqlEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("mysqlDatasource") DataSource dataSource){
        return builder.dataSource(dataSource)
                .packages("com.example.demo.mysql")
                .persistenceUnit("mysql").build();

    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager getMysqlTransactionManager(@Qualifier("mysqlEntityManager") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);

    }

}
