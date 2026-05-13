package com.nexus.profile_service.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProfileRequest {
    @NotNull
    private Long usuarioId;
    @NotBlank
    private String nickname;
    private String avatarUrl;
}