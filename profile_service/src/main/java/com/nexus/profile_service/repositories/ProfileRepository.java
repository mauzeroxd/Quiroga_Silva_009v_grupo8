package com.nexus.profile_service.repositories;


import com.nexus.profile_service.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileModel, Long> {
    Optional<ProfileModel> findByUsuarioId(Long usuarioId);
}