package com.nexus.catalog_service.services;
import com.nexus.catalog_service.dtos.response.VideojuegoResponse;
import com.nexus.catalog_service.exceptions.NotFoundException;
import com.nexus.catalog_service.models.VideojuegoModel;
import com.nexus.catalog_service.repositories.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository repository;

    public List<VideojuegoResponse> findAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public VideojuegoResponse findById(Long id) {
        Objects.requireNonNull(id, "El ID de videojuego es obligatorio");
        VideojuegoModel model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Videojuego no encontrado con ID: " + id));
        return mapToResponse(model);
    }

    private VideojuegoResponse mapToResponse(VideojuegoModel model) {
        return VideojuegoResponse.builder()
                .id(model.getId())
                .titulo(model.getTitulo())
                .genero(model.getGenero())
                .precio(model.getPrecio())
                .plataforma(model.getPlataforma())
                .build();
    }
}