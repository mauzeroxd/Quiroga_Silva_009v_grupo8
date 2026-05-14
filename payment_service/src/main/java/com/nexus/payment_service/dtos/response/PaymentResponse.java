package com.nexus.payment_service.dtos.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentResponse {
    private Long pagoId;
    private Long pedidoId;
    private Double montoPagado;
    private String estado;
    private LocalDateTime fecha;
}