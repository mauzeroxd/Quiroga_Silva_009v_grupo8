package com.nexus.auth_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoUsuarioModel tipo;
}