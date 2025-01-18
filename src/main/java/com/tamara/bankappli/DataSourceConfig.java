package com.tamara.bankappli;

import java.sql.ConnectionBuilder;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    
	@Bean
    public DataSource getDataSource() {
    	
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceBuilder.url("jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;"
                + "database=Bank;"
                + "user=sa;"
                + "password=K1ev2oo1;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("K1ev2oo1");
        return dataSourceBuilder.build();
    			
    }
	
}
