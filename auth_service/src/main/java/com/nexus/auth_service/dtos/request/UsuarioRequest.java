package com.nexus.auth_service.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UsuarioRequest {
    @NotBlank(message = "Username es obligatorio")
    private String username;
    @NotBlank(message = "Password es obligatoria")
    private String password;
    @NotNull(message = "El tipo de usuario es obligatorio")
    private Long tipoId;
}