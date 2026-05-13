package com.nexus.shopping_cart_service.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartRequest {
    @NotNull private Long usuarioId;
    @NotNull private Long juegoId;
    @NotNull @Min(1) private Integer cantidad;
}