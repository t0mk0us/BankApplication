package com.tamara.bankAppli;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration(proxyBeanMethods = false)
public class BankDatasourceConfiguration {

	@Bean
	@ConfigurationProperties("app.datasource.second")
	public HikariDataSource secondDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

}
