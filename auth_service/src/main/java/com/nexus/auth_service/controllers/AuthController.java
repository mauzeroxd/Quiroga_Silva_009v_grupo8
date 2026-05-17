package com.nexus.auth_service.controllers;

import com.nexus.auth_service.dtos.request.UsuarioRequest; // <--- Importamos tu clase exacta
import com.nexus.auth_service.dtos.response.UsuarioResponse;
import com.nexus.auth_service.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired 
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> register(@Valid @RequestBody UsuarioRequest request) { // <--- Usa tu UsuarioRequest
        return new ResponseEntity<>(authService.registrar(request), HttpStatus.CREATED);
    }
}