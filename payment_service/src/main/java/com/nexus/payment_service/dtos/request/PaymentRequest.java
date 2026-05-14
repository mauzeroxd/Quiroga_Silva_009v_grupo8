package com.nexus.payment_service.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PaymentRequest {
    @NotNull private Long pedidoId;
    @NotBlank private String metodoPago;
}