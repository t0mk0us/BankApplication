package com.tamara.bankappli;

import java.util.UUID;

import org.apache.camel.Configuration;
import org.apache.camel.language.bean.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.http.HttpMethod;
import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean(ref = "")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests((authorizeHttpRequests) ->
				authorizeHttpRequests
					.requestMatchers("/**").hasRole("USER"));
            return http.build();
    }

    @Bean(ref = "")
    public UserDetailsService userDetailsService() {
            @SuppressWarnings("deprecation")
			UserDetails user = User.withDefaultPasswordEncoder()
                    .username("user")
                    .password("password")
                    .roles("USER")
                    .build();
            return new InMemoryUserDetailsManager(user);
    }
    
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    // outputs {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
    // remember the password that is printed out and use in the next step
    //System.out.println(encoder.encode("password"));
     
    UserDetails user = User.withUsername("user")
        .password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
        .roles("USER")
        .build();

}
