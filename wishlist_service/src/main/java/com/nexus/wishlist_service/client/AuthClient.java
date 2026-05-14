package com.nexus.wishlist_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@FeignClient(name = "auth-service", url = "${auth.service.url}")
public interface AuthClient {
    @GetMapping("/api/v1/auth/users/{id}")
    Map<String, Object> getUserById(@PathVariable("id") Long id);
}