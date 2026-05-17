package com.nexus.auth_service.services;

import com.nexus.auth_service.dtos.request.UsuarioRequest; // <--- Importamos tu clase exacta
import com.nexus.auth_service.dtos.response.UsuarioResponse;
import com.nexus.auth_service.exceptions.NotFoundException;
import com.nexus.auth_service.models.TipoUsuarioModel;
import com.nexus.auth_service.models.UsuarioModel;
import com.nexus.auth_service.repositories.TipoUsuarioRepository;
import com.nexus.auth_service.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private TipoUsuarioRepository tipoRepository;

    public UsuarioResponse registrar(UsuarioRequest request) { // <--- Recibe tu UsuarioRequest
        Long tipoId = Objects.requireNonNull(request.getTipoId(), "El tipo de usuario es obligatorio");

        // 1. Buscamos el objeto TipoUsuario en la DB usando el tipoId que viene de Postman
        TipoUsuarioModel tipo = tipoRepository.findById(tipoId)
                .orElseThrow(() -> new NotFoundException("El tipo de usuario con ID " + tipoId + " no existe."));

        // 2. Creamos el modelo y le inyectamos la relación completa
        UsuarioModel usuario = new UsuarioModel();
        usuario.setUsername(request.getUsername());
        usuario.setPassword(request.getPassword()); // En producción se aplicaría BCrypt
        usuario.setTipo(tipo); // <--- Aquí pasamos el objeto TipoUsuario mapeado

        // 3. Guardamos en MySQL
        UsuarioModel guardado = usuarioRepository.save(usuario);

        // 4. Retornamos la respuesta limpia (DTO Response)
        return UsuarioResponse.builder()
                .id(guardado.getId())
                .username(guardado.getUsername())
                .rol(guardado.getTipo().getNombreTipo())
                .build();
    }
}