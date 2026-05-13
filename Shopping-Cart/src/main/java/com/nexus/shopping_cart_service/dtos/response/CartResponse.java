package com.nexus.shopping_cart_service.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartResponse {
    private Long id;
    private String nombreUsuario;
    private String nombreJuego;
    private Integer cantidad;
    private Double subtotal;
}