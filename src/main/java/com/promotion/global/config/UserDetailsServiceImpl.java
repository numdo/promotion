package com.promotion.global.config;

import com.promotion.user.model.User;
import com.promotion.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 추가된 임포트
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
public class UserDetailsServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User user = userRepository.findByUserId(username)
                    .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username));
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getUserPassword());
            builder.roles(user.getRole());
            return builder.build();
        };
    }
}
