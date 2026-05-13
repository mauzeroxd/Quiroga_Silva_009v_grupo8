package com.nexus.inventory_service.dtos.response;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CatalogResponse {
    private Long id;
    private String titulo;
    private BigDecimal precio;
}