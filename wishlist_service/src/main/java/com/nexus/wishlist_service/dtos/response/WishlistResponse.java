package com.nexus.wishlist_service.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WishlistResponse {
    private Long id;
    private String usuario;
    private String juego;
    private Double precioActual;
}