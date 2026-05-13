package com.nexus.shopping_cart_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CARRITO")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "juego_id", nullable = false)
    private Long juegoId;

    private Integer cantidad;
}