package com.nexus.auth_service.services;

import com.nexus.auth_service.dtos.request.UsuarioRequest;
import com.nexus.auth_service.dtos.response.UsuarioResponse;
import com.nexus.auth_service.exceptions.NotFoundException;
import com.nexus.auth_service.models.TipoUsuarioModel;
import com.nexus.auth_service.models.UsuarioModel;
import com.nexus.auth_service.repositories.TipoUsuarioRepository;
import com.nexus.auth_service.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private TipoUsuarioRepository tipoRepository;

    public UsuarioResponse registrar(UsuarioRequest request) {
        TipoUsuarioModel tipo = tipoRepository.findById(request.getTipoId())
                .orElseThrow(() -> new NotFoundException("Rol no encontrado"));

        UsuarioModel user = new UsuarioModel();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setTipo(tipo);

        UsuarioModel saved = usuarioRepository.save(user);
        return UsuarioResponse.builder()
                .id(saved.getId()).username(saved.getUsername()).rol(tipo.getNombreTipo()).build();
    }
}