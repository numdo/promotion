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

    public LoginResponseDTO authenticateUser(LoginRequestDTO loginRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getUserId(), loginRequestDTO.getPassword())
            );

            User user = userRepository.findByUserId(loginRequestDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

            String token = jwtUtil.generateToken(user.getUserId(), user.getRole());

            return new LoginResponseDTO(token);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("잘못된 아이디 또는 비밀번호입니다.");
        }
    }
}
