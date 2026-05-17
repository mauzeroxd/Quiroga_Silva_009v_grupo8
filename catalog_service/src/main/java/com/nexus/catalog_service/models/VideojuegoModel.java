package com.nexus.catalog_service.models;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "videojuegos")
public class VideojuegoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String genero;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    private String plataforma;
}