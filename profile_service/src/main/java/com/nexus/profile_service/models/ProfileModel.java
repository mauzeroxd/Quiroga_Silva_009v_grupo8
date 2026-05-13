package com.nexus.profile_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PERFILES")
public class ProfileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId; // FK lógica hacia Auth-Service

    private String nickname;
    private String avatarUrl;
    private Integer nivel = 1;
}