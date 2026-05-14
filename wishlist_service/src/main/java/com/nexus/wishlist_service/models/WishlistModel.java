package com.nexus.wishlist_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LISTA_DESEOS")
public class WishlistModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "juego_id", nullable = false)
    private Long juegoId;
}