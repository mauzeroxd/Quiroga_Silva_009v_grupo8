package com.nexus.auth_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TIPOS_USUARIO")
public class TipoUsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_tipo", nullable = false, length = 20)
    private String nombreTipo;

    private String descripcion;
}