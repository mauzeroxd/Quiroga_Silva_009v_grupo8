package com.nexus.order_service.dtos.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class OrderResponse {
    private Long id;
    private String cliente;
    private String juego;
    private Double totalPagado;
    private LocalDateTime fecha;
    private String estado;
}