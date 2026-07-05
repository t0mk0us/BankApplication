package com.tamara.bankappli;

import java.util.Set;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.tamara.bankappli.model.BankUser;
import com.tamara.bankappli.repository.BankUserRepository;

@Configuration
@EnableWebSecurity
public class BankAppConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF to completely eliminate missing-token authentication loop traps
            .csrf(csrf -> csrf.disable())
            
            // 2. Authorize standard pathways explicitly
            .authorizeHttpRequests(requests -> requests
                // Explicitly allow access to the login endpoint, the physical static file, and static assets
                .requestMatchers("/login", "/login.html", "/error", "/css/**", "/js/**", "/favicon.ico").permitAll()
                // Keep public access open for your bank controllers
                .requestMatchers("/bankapplication/**", "/account/**").permitAll()
                // All other backend application APIs will require an explicit login session
                .anyRequest().authenticated()
            )
            
            // 3. Set up the Form Login mechanism (Spring builds the default exception handlers automatically)
            .formLogin(form -> form
                .loginPage("/login") // Matches your controller endpoint mapping
                .loginProcessingUrl("/login") // Directs the form action POST submit interceptor
                .defaultSuccessUrl("/bankapplication/account", true) // Target landing after authentication succeeds
                .permitAll()
            )
            
            // 4. Configure clean logout processing
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Fallback testing user profile credentials
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
    
    @Bean
    public ApplicationRunner initializer(
            BankUserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUserName("tamara") == null) {
                BankUser user = new BankUser();
                user.setUserName("tamara");
                user.setPassword(passwordEncoder.encode("K1ev2oo1"));
                user.setUserRoles(Set.of("ROLE_ADMIN", "ROLE_DEVELOPER"));
                userRepository.save(user);
                System.out.println(">>> DYNAMIC DATABASE USER 'tamara' REGISTERED SUCCESSFULLY! <<<");
            }
        };
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
