package com.nexus.auth_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity @Table(name = "tipos_usuario")
public class TipoUsuarioModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreTipo;
    private String descripcion;
}