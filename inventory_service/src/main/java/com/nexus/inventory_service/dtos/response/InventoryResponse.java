package com.nexus.inventory_service.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryResponse {
    private Long id;
    private Long videojuegoId;
    private Integer cantidad;
    private String nombreJuego; // Dato enriquecido desde el microservicio Catalog
}