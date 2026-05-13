package com.nexus.auth_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@FeignClient(name = "profile-service", url = "${profile.service.url}")
public interface ProfileClient {
    @PostMapping("/api/v1/profiles")
    void createProfile(@RequestBody Map<String, Object> profileData);
}