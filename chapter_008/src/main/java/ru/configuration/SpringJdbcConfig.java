package ru.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("ru.db")
@PropertySource("classpath:application.properties")
public class SpringJdbcConfig {
    @Value("${datasource.jdbc}")
    String jdbc;
    @Value("${datasource.url}")
    String url;
    @Value("${datasource.username}")
    String username;
    @Value("${datasource.password}")
    String password;


    @Bean
    public DataSource jdbcDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbc);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
