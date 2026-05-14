package com.nexus.review_service.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponse {
    private Long id;
    private String usuario;
    private String juego;
    private Integer estrellas;
    private String reseña;
}