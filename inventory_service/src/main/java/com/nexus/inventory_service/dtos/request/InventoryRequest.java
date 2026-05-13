package com.nexus.inventory_service.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class InventoryRequest {
    @NotNull(message = "El ID del juego es obligatorio")
    private Long juegoId;

    @NotBlank(message = "La clave del producto es obligatoria")
    private String codigoKey;
}