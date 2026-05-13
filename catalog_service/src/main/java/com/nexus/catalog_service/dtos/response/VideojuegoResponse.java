package com.nexus.catalog_service.dtos.response;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class VideojuegoResponse {
    private Long id;
    private String titulo;
    private String genero;
    private BigDecimal precio;
    private String plataforma;
}