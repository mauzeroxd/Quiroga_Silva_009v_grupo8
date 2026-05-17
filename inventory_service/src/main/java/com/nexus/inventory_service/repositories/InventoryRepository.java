package com.nexus.inventory_service.repositories;

import com.nexus.inventory_service.models.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryModel, Long> {
}
