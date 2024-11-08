package com.promotion.global.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey; // 최소 32바이트 (256비트) 이상이어야 함

    @Value("${jwt.expiration}")
    private long expirationTime; // 예: 86400000 (1일)

    private Key key;

    @PostConstruct
    public void init() {
        // 비밀 키 초기화 (HMAC SHA로 생성)
        key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // 토큰 생성
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username) // 사용자 이름
                .claim("role", role)  // 역할 정보
                .setIssuedAt(new Date()) // 토큰 발급 시간
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // 만료 시간 설정
                .signWith(key, SignatureAlgorithm.HS256) // 서명 방식 (HS256 사용)
                .compact();
    }

    // 토큰에서 사용자 이름과 역할 추출
    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 사용자 이름 추출
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // 역할(role) 추출
    public String extractRole(String token) {
        return (String) extractClaims(token).get("role");
    }

    // 토큰 유효성 검증
    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // 토큰 만료 여부 확인
    private boolean isTokenExpired(String token) {
        Date expiration = extractClaims(token).getExpiration();
        return expiration.before(new Date());
    }

    // 토큰이 유효한지 확인 (헤더에서 토큰을 추출하고 검증하는 로직)
    public boolean isTokenValid(String token) {
        try {
            // 토큰 파싱 및 유효성 검증
            extractClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // 토큰이 잘못되었거나 만료된 경우 예외가 발생하므로 false 리턴
            return false;
        }
    }
}
