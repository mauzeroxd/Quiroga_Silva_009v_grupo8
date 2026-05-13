package com.nexus.catalog_service.repositories;

import com.nexus.catalog_service.models.VideojuegoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideojuegoRepository extends JpaRepository<VideojuegoModel, Long> {
    // Aquí se pueden implementar Query Methods personalizados [cite: 37]
}