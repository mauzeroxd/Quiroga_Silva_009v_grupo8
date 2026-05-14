package com.nexus.wishlist_service.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WishlistRequest {
    @NotNull private Long usuarioId;
    @NotNull private Long juegoId;
}