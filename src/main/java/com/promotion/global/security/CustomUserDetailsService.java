package com.promotion.global.security;

import com.promotion.user.model.UserDto;
import com.promotion.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
// 추가된 임포트
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDto user = null;
        user = userRepository.findByUserId(userId);
        if(user == null) {
            throw new UsernameNotFoundException(userId);
        }
        return new CustomUserDetails(user);
    }
}
