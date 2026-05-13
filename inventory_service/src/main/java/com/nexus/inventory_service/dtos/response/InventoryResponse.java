package com.nexus.inventory_service.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryResponse {
    private Long id;
    private String codigoKey;
    private Integer vendido;
    private String nombreJuego; // Dato enriquecido desde el microservicio Catalog
}