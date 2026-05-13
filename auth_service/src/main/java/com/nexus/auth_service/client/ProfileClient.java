package com.nexus.auth_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

// Cambiamos el url a uno fijo por ahora para evitar el error de URI Parser
@FeignClient(name = "profile-service", url = "http://profile-service:8083")
public interface ProfileClient {
    @PostMapping("/api/v1/profiles")
    void createProfile(@RequestBody Map<String, Object> profileData);
}