package com.nexus.inventory_service.dtos.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class InventoryRequest {
    @NotNull(message = "El ID del videojuego es obligatorio")
    @JsonAlias({"videojuegoId", "juegoId"})
    private Long videojuegoId;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;
}