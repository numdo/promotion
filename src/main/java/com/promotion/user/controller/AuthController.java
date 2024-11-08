package com.promotion.user.controller;

import com.promotion.global.config.JwtUtil;
import com.promotion.user.dto.request.LoginRequestDTO;
import com.promotion.user.dto.response.LoginResponseDTO;
import com.promotion.user.service.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService authService;

    // 로그인 API
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        // 사용자 인증 처리
        LoginResponseDTO loginResponse = authService.authenticateUser(loginRequestDTO);
        String token = loginResponse.getToken();

        // 토큰을 쿠키에 저장 (옵션: 브라우저 종료 시 자동 삭제)
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true); // 클라이언트에서 접근 불가
        cookie.setPath("/"); // 모든 경로에서 접근 가능
        cookie.setMaxAge(60 * 60); // 1시간 동안 유효
        response.addCookie(cookie);

        // 성공 응답 (JWT 토큰 포함)
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", "Login successful");
        responseMap.put("token", token);
        return ResponseEntity.ok(responseMap);
    }

    // 로그아웃 API (쿠키에서 토큰 삭제)
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // 쿠키 삭제
        response.addCookie(cookie);

        // 로그아웃 성공 응답
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Logout successful");
        return ResponseEntity.ok(responseMap);
    }

    // 토큰을 이용한 인증 확인
    @GetMapping("/verify")
    public ResponseEntity<Map<String, String>> verifyToken(@CookieValue("jwt") String token) {
        if (token == null || !jwtUtil.isTokenValid(token)) {
            return ResponseEntity.status(401).body(createErrorResponse("Invalid or expired token"));
        }

        String username = jwtUtil.extractUsername(token);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Token is valid");
        responseMap.put("username", username);
        return ResponseEntity.ok(responseMap);
    }

    // 에러 응답 생성 (중복 제거)
    private Map<String, String> createErrorResponse(String message) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", message);
        return errorResponse;
    }
}
