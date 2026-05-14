package com.nexus.review_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESEÑAS")
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "juego_id", nullable = false)
    private Long juegoId;

    @Column(nullable = false)
    private Integer calificacion; // 1 a 5 estrellas

    @Column(length = 500)
    private String comentario;
}