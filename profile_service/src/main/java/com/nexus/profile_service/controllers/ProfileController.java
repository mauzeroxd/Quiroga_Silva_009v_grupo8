package com.nexus.profile_service.controllers;

import com.nexus.profile_service.dtos.request.ProfileRequest;
import com.nexus.profile_service.dtos.response.ProfileResponse;
import com.nexus.profile_service.services.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    @Autowired private ProfileService service;

    @PostMapping
    public ResponseEntity<ProfileResponse> create(@Valid @RequestBody ProfileRequest request) {
        return ResponseEntity.ok(service.createProfile(request));
    }
}