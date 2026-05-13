package com.nexus.inventory_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "STOCK_KEYS") // Tabla específica del microservicio de inventario
public class StockKeyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "juego_id", nullable = false)
    private Long juegoId; // FK lógica hacia el microservicio Catalog

    @Column(name = "codigo_key", unique = true, nullable = false)
    private String codigoKey;

    @Column(nullable = false)
    private Integer vendido; // 0 = Disponible, 1 = Vendido
}