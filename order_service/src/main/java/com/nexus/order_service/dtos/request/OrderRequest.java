package com.nexus.order_service.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {
    @NotNull(message = "ID de usuario es obligatorio")
    private Long usuarioId;
    
    @NotNull(message = "ID de juego es obligatorio")
    private Long juegoId;
}