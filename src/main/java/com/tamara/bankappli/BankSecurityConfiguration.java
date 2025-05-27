package com.tamara.bankappli;

import java.util.Arrays;
import java.util.UUID;

import javax.naming.Context;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AnonymousConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import jakarta.activation.DataSource;
import jakarta.websocket.Encoder;


@Configuration
public class WebSecurityConfig {

	/*
	 * @org.springframework.context.annotation.Bean(initMethod = "") public
	 * SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	 * http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
	 * .requestMatchers("/**").hasRole("USER")); return http.build(); }
	 */
	/*
	 * @Bean public WebSecurityCustomizer webSecurityCustomizer() { return (web) ->
	 * web.ignoring().requestMatchers("/ignore1", "/ignore2"); }
	 */
	 
	    @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        configuration.setAllowedMethods(Arrays.asList("*"));
	        configuration.setAllowedHeaders(Arrays.asList("*"));
	        configuration.setAllowCredentials(true);
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	    
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, @Autowired AuthenticationManager authenticationManager) throws Exception {
	        return httpSecurity
	                .csrf(AbstractHttpConfigurer::disable)
	                .cors(AbstractHttpConfigurer::disable)
	                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .authenticationManager(authenticationManager)
	                .formLogin(AbstractHttpConfigurer::disable)
	                .httpBasic(AbstractHttpConfigurer::disable)
	                .logout(LogoutConfigurer::disable)
	                .anonymous(AnonymousConfigurer::disable)
//	                .authorizeHttpRequests(auths -> auths
//	                        .requestMatchers("/products/**").permitAll()
//	                        .anyRequest().authenticated()
//	                )
	                .build();
	    }
    
    @Bean
    public AuthenticationManager webAuthenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        var provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(provider);
    }
	
	@Bean(initMethod = "")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests((authorizeHttpRequests) ->
				authorizeHttpRequests
					.requestMatchers("/**").permitAll());
            return http.build();
    }

    @Bean(initMethod = "")
    public UserDetailsService userDetailsService() {
            @SuppressWarnings("deprecation")
			UserDetails user = User.withDefaultPasswordEncoder()
                    .username("sa")
                    .password("K1ev2oo1")
                    .roles("USER")
                    .build();
            return new InMemoryUserDetailsManager(user);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }
     
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    // outputs {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
    // remember the password that is printed out and use in the next step

    
    UserDetails user = User.withUsername("user")
        .password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
        .roles("USER")
        .build();

}
