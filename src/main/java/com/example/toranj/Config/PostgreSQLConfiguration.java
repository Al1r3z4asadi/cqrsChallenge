package com.example.toranj.Config;

import javax.sql.DataSource;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.toranj.DataAccess.Write",
        entityManagerFactoryRef = "postgreEntityManagerFactory",
        transactionManagerRef = "postgreTransactionManager"
)
public class PostgreSQLConfiguration {

    @Primary
    @Bean(name = "postgreDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "postgreEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("postgreDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.toranj.Core.DomainObjects")
                .persistenceUnit("postgres")
                .build();
    }

    @Primary
    @Bean(name = "postgreTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("postgreEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}