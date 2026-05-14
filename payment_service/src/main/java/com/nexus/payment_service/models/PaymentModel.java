package com.nexus.payment_service.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PAGOS")
public class PaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id", nullable = false)
    private Long pedidoId;

    private Double monto;
    private String metodoPago; // Ej: 'TARJETA', 'TRANSFERENCIA'
    private String estado;      // Ej: 'APROBADO', 'RECHAZADO'
    private LocalDateTime fechaPago;
}