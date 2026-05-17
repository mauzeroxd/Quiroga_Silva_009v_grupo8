package com.nexus.catalog_service.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VideojuegoRequest {
    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El género es obligatorio")
    private String genero;

    @NotNull(message = "El precio es obligatorio")
    private Double precio;

    @NotBlank(message = "La plataforma es obligatoria")
    private String plataforma;
}