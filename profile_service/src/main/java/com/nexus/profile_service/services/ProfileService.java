package com.nexus.profile_service.services;

import com.nexus.profile_service.client.AuthClient;
import com.nexus.profile_service.dtos.request.ProfileRequest;
import com.nexus.profile_service.dtos.response.ProfileResponse;
import com.nexus.profile_service.exceptions.RemoteServiceException;
import com.nexus.profile_service.models.ProfileModel;
import com.nexus.profile_service.repositories.ProfileRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    
    @Autowired private ProfileRepository repository;
    @Autowired private AuthClient authClient;

    public ProfileResponse createProfile(ProfileRequest request) {
        try {
            var user = authClient.getUserById(request.getUsuarioId());
            
            ProfileModel model = new ProfileModel();
            model.setUsuarioId(request.getUsuarioId());
            model.setNickname(request.getNickname());
            model.setAvatarUrl(request.getAvatarUrl());
            
            ProfileModel saved = repository.save(model);
            
            return ProfileResponse.builder()
                    .id(saved.getId())
                    .nickname(saved.getNickname())
                    .nivel(saved.getNivel())
                    .username(user.get("username").toString())
                    .build();
        } catch (FeignException.NotFound e) {
            throw new RemoteServiceException("El Usuario no existe");
        }
    }
}