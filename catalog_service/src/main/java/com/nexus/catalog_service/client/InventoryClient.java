package com.nexus.catalog_service.client;

import com.nexus.catalog_service.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", url = "${inventory.service.url:http://inventory-service:8082}", configuration = FeignConfig.class)
public interface InventoryClient {
    // Ejemplo: Consultar si hay stock disponible para un juego
    @GetMapping("/api/v1/inventory/check/{juegoId}")
    Boolean checkStock(@PathVariable("juegoId") Long juegoId);
}