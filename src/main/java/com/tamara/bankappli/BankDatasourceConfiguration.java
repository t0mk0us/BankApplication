package com.tamara.bankappli;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariDataSource;

@Configuration(proxyBeanMethods = false)
public class BankDatasourceConfiguration {
	
	public DataSource bankDataSource = getDataSource();
	
	@Bean
    public static DataSource getDataSource() {
    	
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
	/*
	 * @Bean
	 * 
	 * @ConfigurationProperties("app.datasource.second") public HikariDataSource
	 * secondDataSource() { return
	 * DataSourceBuilder.create().type(HikariDataSource.class).build(); }
	 */

	/*
	 * @Bean LocalContainerEntityManagerFactoryBean
	 * bankEmf(@Qualifier("bankDataSource") DataSource bankDataSource,
	 * EntityManagerFactoryBuilder builder) { return
	 * builder.dataSource(bankDataSource).build(); }
	 */
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    	
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.SQLServerDialect");
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("com.tamara.bankappli.model");

        return factory;
    }
}
