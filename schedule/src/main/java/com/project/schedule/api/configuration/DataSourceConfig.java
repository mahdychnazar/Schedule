package com.project.schedule.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@PropertySources({
        @PropertySource("classpath:application-dev.properties"),
        @PropertySource("classpath:application-prod.properties")
})
public class DataSourceConfig {

    DataSource dataSource;

    @Value("${spring.datasource.driverClassName}")
    String driverClassName;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;

    @Bean
    @Profile("dev")
    public DataSource getDevDataSource(){
        return getDataSource();
    }

    @Bean
    @Profile("prod")
    public DataSource getProdDataSource(){
        return getDataSource();
    }

    private DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        dataSource = dataSourceBuilder.build();
        return dataSource;
    }
}
