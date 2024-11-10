package com.promotion.user.service;

import com.promotion.global.security.JwtProvider;
import com.promotion.global.security.TokenInfo;
import com.promotion.user.dto.request.LoginRequestDTO;
import com.promotion.user.dto.response.LoginResponseDTO;
import com.promotion.user.model.UserDto;
import com.promotion.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtProvider jwtProvider;


    public TokenInfo login(LoginRequestDTO loginRequestDTO) throws SQLException {
        // 1. ID와 암호화된 PW를 기반으로 Authentication 객체 생성
        // 이 때 authentication 은 인증 여부를 확인하는 authenticated 값이 false 로 설정되어있음.
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUserId(), loginRequestDTO.getPassword());

        // 2. 실제 검증 과정 (사용자 비밀번호 확인)
        // authenticate 함수가 실행되면, CustomUserDetailsService 에서 구현한 loadUserByUsername 함수가 자동으로 실행 됨.
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 다른데서 사용시
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal(); 이캐 갖다쓰면 된다.

        UserDto user = userRepository.findByUserId(loginRequestDTO.getUserId());
        if (user == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "입력된 정보와 일치하는 사용자가 없습니다.");

        // 3. 인증 정보를 기반으로 JWT 생성 및 반환
        return jwtProvider.generateToken(authentication, user);
    }
    public void logout() throws Exception {
        SecurityContextHolder.clearContext();
        // 그 외 로그아웃 로직 처리(블랙리스트)
    }
}