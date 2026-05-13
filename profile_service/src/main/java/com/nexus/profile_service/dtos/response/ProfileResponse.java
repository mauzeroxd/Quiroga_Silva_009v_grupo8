package com.nexus.profile_service.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileResponse {
    private Long id;
    private String nickname;
    private Integer nivel;
    private String username; // Se obtiene de Auth-Service
}