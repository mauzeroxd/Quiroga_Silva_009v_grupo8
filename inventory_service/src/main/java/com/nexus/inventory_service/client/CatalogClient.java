package com.nexus.inventory_service.client;

import com.nexus.inventory_service.config.FeignConfig;
import com.nexus.inventory_service.dtos.response.CatalogResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "catalog-service", 
    url = "${catalog.service.url}", 
    configuration = FeignConfig.class
)
public interface CatalogClient {
    @GetMapping("/api/v1/videojuegos/{id}")
    CatalogResponse getJuegoById(@PathVariable("id") Long id);
}