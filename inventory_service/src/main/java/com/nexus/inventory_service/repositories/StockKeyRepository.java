package com.nexus.inventory_service.repositories;

import com.nexus.inventory_service.models.StockKeyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StockKeyRepository extends JpaRepository<StockKeyModel, Long> {
    Optional<StockKeyModel> findByCodigoKey(String codigoKey); // Query Method [cite: 36]
}