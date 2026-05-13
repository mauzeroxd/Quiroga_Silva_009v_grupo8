package com.nexus.auth_service.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponse {
    private Long id;
    private String username;
    private String rol;
}