package com.techlabs.app.controller;

import com.techlabs.app.dto.JWTAuthResponse;
import com.techlabs.app.dto.LoginDTO;
import com.techlabs.app.dto.RegisterDTO;
import com.techlabs.app.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDTO loginDTO) {
        logger.info("User login with username: {}", loginDTO.getUsername());
        String token = authService.login(loginDTO);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"/register", "/signup"}, consumes = {"multipart/form-data"})
    public ResponseEntity<String> register(@RequestPart("registerDTO") RegisterDTO registerDTO,
                                           @RequestParam(name = "role") String tempRole,
                                           @RequestPart("file") MultipartFile file) {
        String role = "ROLE_" + tempRole.toUpperCase();
        logger.info("User registration with role: {}", role);
        String response = authService.register(registerDTO, role, file);
        return ResponseEntity.ok(response);
    }
}
