package com.tamara.bankappli.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tamara.bankappli.repository.BankUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final BankUserRepository userRepository;

    public CustomUserDetailsService(BankUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username)
        		.map(user -> User.withUsername(user.getUserName())
                .password(user.getPassword()) // Will read encrypted passwords
                .authorities(user.getUserRoles().toArray(new String[0]))
                .build())
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
