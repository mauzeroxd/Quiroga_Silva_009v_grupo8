package com.nexus.auth_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity @Table(name = "usuarios")
public class UsuarioModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @ManyToOne @JoinColumn(name = "tipo_id")
    private TipoUsuarioModel tipo;
}