package com.tamara.bankappli;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	/*
	 * @Bean
	 * 
	 * @Primary
	 * 
	 * @ConfigurationProperties("spring.dsmysql") public DataSourceProperties
	 * firstDataSourceProperties() { return new DataSourceProperties(); }
	 * 
	 * @Bean
	 * 
	 * @Primary
	 * 
	 * @ConfigurationProperties("spring.dsmysql") public DataSource
	 * primaryDataSource() { return
	 * firstDataSourceProperties().initializeDataSourceBuilder().build(); }
	 */
	  	 
	@Bean
	public IntegrationDataSourceScriptDatabaseInitializer customIntegrationDataSourceInitializer(DataSource dataSource) {
	    return new IntegrationDataSourceScriptDatabaseInitializer(dataSource, new DatabaseInitializationSettings());
	}
}
