package com.promotion.user.service;

import com.promotion.global.config.JwtUtil;
import com.promotion.user.dto.request.LoginRequestDTO;
import com.promotion.user.dto.response.LoginResponseDTO;
import com.promotion.user.model.User;
import com.promotion.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    // 로그인 인증 처리
    public LoginResponseDTO authenticateUser(LoginRequestDTO loginRequestDTO) {
        try {
            // 아이디와 비밀번호로 인증 시도
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getUserId(), loginRequestDTO.getPassword())
            );

            // 인증 성공 시 사용자 정보 가져오기
            User user = userRepository.findByUserId(loginRequestDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

            // JWT 토큰 생성
            String token = jwtUtil.generateToken(user.getUserId(), user.getRole());

            // 생성된 토큰을 응답 DTO로 반환
            return new LoginResponseDTO(token);
        } catch (BadCredentialsException e) {
            // 인증 실패 시 예외 처리
            throw new RuntimeException("잘못된 아이디 또는 비밀번호입니다.");
        }
    }
}
