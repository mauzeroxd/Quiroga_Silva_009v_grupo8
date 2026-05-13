package com.nexus.catalog_service.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class VideojuegoRequest {
    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    private String genero;

    @NotNull(message = "El precio no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal precio;

    private String plataforma;
}