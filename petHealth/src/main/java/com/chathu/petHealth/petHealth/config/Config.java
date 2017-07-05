package com.chathu.petHealth.petHealth.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by chansani on 7/4/2017.
 */

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class Config {


    private static final String HIBERNATE_DIALECT_KEY = "hibernate.dialect";

    private static final String HIBERNATE_FORMAT_SQL_KEY = "hibernate.format_sql";

    private static final String PROP_KEY_DB_DRIVER = "db.driver";

    private static final String PROP_KEY_DB_URL = "db.url";

    private static final String PROP_KEY_DB_USERNAME = "db.username";

    private static final String PROP_KEY_DB_PASSWORD = "db.password";

    private static final String PROP_KEY_SCAN_PACKAGES = "entitymanager.packages.to.scan";

    private static final String PROP_KEY_HIBERNATE_DIALECT = "hibernate.dialect";

    private static final String PROP_KEY_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";

    @Resource
    private Environment env;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(PROP_KEY_DB_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROP_KEY_DB_URL));
        dataSource.setUsername(env.getRequiredProperty(PROP_KEY_DB_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROP_KEY_DB_PASSWORD));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { env.getRequiredProperty(PROP_KEY_SCAN_PACKAGES) });
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty(HIBERNATE_DIALECT_KEY, env.getRequiredProperty(PROP_KEY_HIBERNATE_DIALECT));
        properties.setProperty(HIBERNATE_FORMAT_SQL_KEY, env.getRequiredProperty(PROP_KEY_HIBERNATE_FORMAT_SQL));
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
