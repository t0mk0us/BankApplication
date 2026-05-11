package com.tamara.bankappli;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/bankapplication/address/*").setViewName("Address");
		registry.addViewController("/bankapplication/account/*").setViewName("Account");
		registry.addViewController("/bankapplication/currency/*").setViewName("Currency");
		registry.addViewController("/bankapplication/person/*").setViewName("Person");
		registry.addViewController("/bankapplication/login").setViewName("Login");
		registry.addViewController("/login").setViewName("login");
	}
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("http://localhost:3015") // Replace with your React app's origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                //.allowedHeaders("*")
                .allowedHeaders("Content-Type", "Authorization", "Access-Control-Allow-Origin")
                .allowCredentials(true)
                .maxAge(3600);
    }
}