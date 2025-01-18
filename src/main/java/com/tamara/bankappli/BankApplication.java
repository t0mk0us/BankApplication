package com.tamara.bankappli;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.integration.IntegrationDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import de.codecentric.boot.admin.server.config.EnableAdminServer;
import jakarta.persistence.EntityManagerFactory;

import com.tamara.bankappli.model.Address;
import com.tamara.bankappli.repository.AddressRepository;

//@EnableAdminServer
@SpringBootApplication
public class BankApplication {
	
	DataSource ds = new DataSourceConfig().getDataSource();
	
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	  	 
	
	  @Bean public IntegrationDataSourceScriptDatabaseInitializer
	  customIntegrationDataSourceInitializer(DataSource dataSource) throws SQLException {
	  
		  System.out.println("DataSource is " + ds.toString());
		  System.out.println("DataSource is " + ds.getConnection());
		  return new IntegrationDataSourceScriptDatabaseInitializer(this.ds, new
		  DatabaseInitializationSettings()); 
	  
	  }
	  

	    @Bean
	    public CommandLineRunner run(AddressRepository addressRepository) throws Exception {
	        return (String[] args) -> {
	            /*Address user1 = new Address("John", "john@domain.com");
	            Address user2 = new Address("Julie", "julie@domain.com");
	            AddressRepository.save(user1);
	            AddressRepository.save(user2);*/
	            addressRepository.findAll().forEach(Address -> System.out.println(Address));
	        };
	    }
	 
}
