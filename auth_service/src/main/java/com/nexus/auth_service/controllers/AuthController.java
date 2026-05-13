package com.nexus.auth_service.controllers;

import com.nexus.auth_service.dtos.request.UsuarioRequest;
import com.nexus.auth_service.dtos.response.UsuarioResponse;
import com.nexus.auth_service.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> register(@Valid @RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(service.registrar(request));
    }
}