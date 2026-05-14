package com.nexus.review_service.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ReviewRequest {
    @NotNull private Long usuarioId;
    @NotNull private Long juegoId;
    @Min(1) @Max(5) private Integer calificacion;
    @NotBlank @Size(max = 500) private String comentario;
}