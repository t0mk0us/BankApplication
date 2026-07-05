package com.tamara.bankappli;

import java.util.Set;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.tamara.bankappli.model.BankUser;
import com.tamara.bankappli.repository.BankUserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class BankAppConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, BankUserRepository userRepository) throws Exception {
        http
            // 1. Apply global CORS configuration source & disable CSRF for local development API testing
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            
            // 2. Configure access policies
            .authorizeHttpRequests(requests -> requests
                // Permit entry to your auth routes and system tracking errors unconditionally
                .requestMatchers("/bankapplication/login", "/error").permitAll()
                // Keep business domain APIs accessible 
                .requestMatchers("/bankapplication/**", "/account/**").permitAll()
                .anyRequest().authenticated()
            )
            
            // 3. Process the React application login via form login architecture natively
            .formLogin(form -> form
                .loginProcessingUrl("/bankapplication/login") // Intercepts the request on port 8090
                .usernameParameter("username")
                .passwordParameter("password")
                
                // On successful login, write the exact JSON payload your React app expects
                .successHandler((request, response, authentication) -> {
                    String username = authentication.getName();
                    
                    BankUser dbUser = userRepository.findByUserName(username)
                        .orElseThrow(() -> new RuntimeException("Database look up integrity breach"));

                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(jakarta.servlet.http.HttpServletResponse.SC_OK);
                    
                    Long customerId = (dbUser.getCustomer() != null) ? dbUser.getCustomer().getID() : null;
                    
                    String jsonResponse = String.format(
                        "{\"username\":\"%s\",\"customerId\":%s}",
                        dbUser.getUserName(),
                        customerId != null ? customerId.toString() : "null"
                    );
                    
                    response.getWriter().write(jsonResponse);
                })
                
                // Return a clean 401 JSON packet instead of an HTML page redirect on failure
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(jakarta.servlet.http.HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("{\"error\":\"Invalid username or password\"}");
                })
            )
            
            .logout(logout -> logout
                .logoutUrl("/bankapplication/logout")
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setStatus(jakarta.servlet.http.HttpServletResponse.SC_OK);
                })
            );

        return http.build();
    }

    // Centralized CORS policy matching your React frontend port perfectly
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3015")); // Whitelist React port 3015
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true); // Permits sharing session cookies across ports 3015 and 8090
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
            UserDetailsService userDetailsService, 
            PasswordEncoder passwordEncoder) {
        
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService); 
        provider.setPasswordEncoder(passwordEncoder);       
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService(BankUserRepository userRepository) {
        return username -> {
            BankUser bankUser = userRepository.findByUserName(username)
                    .orElseThrow(() -> new org.springframework.security.core.userdetails.UsernameNotFoundException(
                            "User profile not found in database: " + username));

            return org.springframework.security.core.userdetails.User.withUsername(bankUser.getUserName())
                    .password(bankUser.getPassword()) 
                    .roles(bankUser.getUserRoles().toArray(new String[0])) 
                    .build();
        };
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ApplicationRunner initializer(BankUserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUserName("tamara_fixed").isEmpty()) {
                BankUser user = new BankUser();
                user.setUserName("tamara_fixed");
                user.setPassword(passwordEncoder.encode("K1ev2oo1"));
                user.setUserRoles(Set.of("ADMIN", "DEVELOPER")); 
                userRepository.saveAndFlush(user); 
                System.out.println(">>> 🟢 SEED USER 'tamara_fixed' SUCCESSFULLY CREATED IN DATABASE! <<<");
            }
        };
    }
}
