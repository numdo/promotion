package com.promotion.user.controller;

import com.promotion.global.security.TokenInfo;
import com.promotion.user.service.AuthService;
import com.promotion.user.dto.request.LoginRequestDTO;
import com.promotion.user.dto.response.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "*", allowCredentials = "true")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenInfo> login(@RequestBody LoginRequestDTO loginRequestDTO) throws SQLException {
        TokenInfo token = authService.login(loginRequestDTO);
        return ResponseEntity.ok(token);
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout() throws Exception {
        authService.logout();
        return ResponseEntity.ok("Logout successful");
    }
}