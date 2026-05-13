package com.nexus.auth_service.repositories;

import com.nexus.auth_service.models.TipoUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioModel, Long> {
}