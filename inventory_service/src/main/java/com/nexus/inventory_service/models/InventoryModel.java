package com.nexus.inventory_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventario")
public class InventoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "videojuego_id", nullable = false)
    private Long videojuegoId;

    @Column(nullable = false)
    private Integer cantidad;
}
