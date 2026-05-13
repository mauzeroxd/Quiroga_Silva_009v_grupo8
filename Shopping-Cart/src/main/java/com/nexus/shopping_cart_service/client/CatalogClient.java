package com.nexus.shopping_cart_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@FeignClient(name = "catalog-service", url = "${catalog.service.url}")
public interface CatalogClient {
    @GetMapping("/api/v1/videojuegos/{id}")
    Map<String, Object> getJuegoById(@PathVariable("id") Long id);
}